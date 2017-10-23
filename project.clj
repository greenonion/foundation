(defproject foundation "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0-beta2"]
                 [aero "1.1.2"]
                 [com.stuartsierra/component "0.3.2"]
                 [compojure "1.6.0"]
                 [org.clojure/tools.logging "0.4.0"]
                 [ring/ring-core "1.6.2"]
                 [ring/ring-jetty-adapter "1.6.2"]
                 [ring/ring-json "0.4.0"]]
  :main ^:skip-aot foundation.core
  :target-path "target/%s"
  :repl-options {:init-ns user}
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[reloaded.repl "0.2.4"]]
                   :source-paths ["dev"]}})
