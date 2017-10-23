(ns foundation.components.web-server
  (:require [clojure.tools.logging :refer :all]
            [com.stuartsierra.component :as component]
            [ring.adapter.jetty :as jetty]
            [foundation.routes :as routes]))

(defrecord WebServer [host port db http-server]
  component/Lifecycle
  (start [this]
    (if http-server
      this ; already started
      (let [jetty (jetty/run-jetty (routes/app db)
                                   {:host host
                                    :port port
                                    :join? false})]
        (infof "Started web-server on port %s" port)
        (assoc this :http-server jetty))))
  (stop [this]
    (if (not http-server) ; already stopped
      this
      (do (.stop (:http-server this))
          (assoc this :http-server nil)))))

(defn new-web-server
  "Returns a new instance of the web server component which
  creates its handler dynamically."
  [m]
  (component/using (map->WebServer m) [:db]))
