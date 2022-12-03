(ns build
  (:refer-clojure :exclude [test])
  (:require [org.corfield.build :as bb]))

(def lib 'net.clojars.danielmartincraig/coffi-demo-deps)
(def version "0.1.0-SNAPSHOT")
(def main 'danielmartincraig.coffi-demo-deps)

(defn test "Run the tests." [opts]
  (bb/run-tests opts))

(defn ci "Run the CI pipeline of tests (and build the uberjar)." [opts]
  (-> opts
      (assoc :lib lib :version version :main main :java-opts ["--add-modules=jdk.incubator.foreign" "--enable-native-access=ALL-UNNAMED"])
      (bb/run-tests)
      (bb/clean)
      (bb/uber)))
