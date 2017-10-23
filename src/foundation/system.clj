(ns foundation.system
  "Components and their dependency relationships."
  (:require
   [aero.core :as aero]
   [clojure.java.io :as io]
   [com.stuartsierra.component :refer [system-map system-using]]
   [foundation.components.db :as db]
   [foundation.components.web-server :as web-server]))

(defn config
  "Read EDN config, with the given profile. See Aero docs at
  https://github.com/juxt/aero for details."
  [profile]
  (aero/read-config (io/resource "config.edn") {:profile profile}))

(defn new-system-map
  "Create the system. See https://github.com/stuartsierra/component"
  [config]
  (system-map
   :web-server (web-server/new-web-server (:web-server config))
   :db (db/new-database {:data {"a" 1234}}))) ; bootstrap dev data here

(defn new-dependency-map
  "Declare the dependency relationships between components. See
  https://github.com/stuartsierra/component"
  []
  {})

(defn new-system
  "Construct a new system, configured with the given profile"
  [profile]
  (let [config (config profile)]
    (-> (new-system-map config)
        (system-using (new-dependency-map)))))
