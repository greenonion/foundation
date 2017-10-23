(ns foundation.components.db
  (:require [com.stuartsierra.component :as component]))

(defn get-entry
  [db k]
  (get @(:data db) k))

(defn add-entry
  [db k v]
  (swap! (:data db) #(assoc % k v)))

(defn inspect
  [db]
  (keys @(:data db)))

(defrecord Database [data]
  component/Lifecycle
  (start [this]
    (assoc this :data (atom data)))

  (stop [this]
    this))

(defn new-database [m]
  (map->Database m))
