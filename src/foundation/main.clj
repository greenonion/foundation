(ns foundation.main
  (:require [foundation.components.db :as db]))

(defn home [db request]
  "Home :)\n")

(defn document [db id]
  (str (db/get-entry db id)))

(defn index [db id value]
  (prn id value)
  (db/add-entry db id value))
