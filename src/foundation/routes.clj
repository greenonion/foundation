(ns foundation.routes
  (:require [compojure.core :as compojure :refer [GET POST PUT]]
            [compojure.route :as route]
            [com.stuartsierra.component :as component]
            [ring.middleware.params :as params]
            [ring.middleware.json :as json]
            [foundation.main :as main]))

(defn wrap-middleware [routes]
  (-> routes
      params/wrap-params
      json/wrap-json-params))

(defn app-routes [db]
  (compojure/routes
   (GET "/" request (main/home db request))
   (GET "/document/:id" [id] (main/document db id))
   (PUT "/document/:id" [id :as {params :params}]
     (let [data (dissoc params :id)]
         (main/index db id data)))
   (route/not-found "Not Found")))

(defn app
  "Returns the web handler function as a closure over the
  application component."
  [db]
  (wrap-middleware (app-routes db)))




