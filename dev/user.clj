(ns user
  (:require
   [clojure.java.io :as io]
   [clojure.repl :refer [apropos dir doc find-doc pst source]]
   [clojure.test :refer [run-all-tests]]
   [com.stuartsierra.component :as component]
   [reloaded.repl :refer [system init start stop go reset reset-all]]
   [foundation.system :as system]))

(defn new-dev-system
  "Create a development system"
  []
  (component/system-using
   (system/new-system-map (system/config :dev))
   (system/new-dependency-map)))

(reloaded.repl/set-init! new-dev-system)

(defn test-all []
  (run-all-tests #"foundation.*test$"))

(defn reset-and-test []
  (reset)
  (time (test-all)))
