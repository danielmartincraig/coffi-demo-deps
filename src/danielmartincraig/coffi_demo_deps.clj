(ns danielmartincraig.coffi-demo-deps
  (:gen-class)
  (:require [coffi.mem :as mem :refer [defalias]]
            [coffi.ffi :as ffi :refer [defcfn]]))

(defcfn strlen
  "Given a string, measures its length in bytes."
  strlen [::mem/c-string] ::mem/long)

(defn process-input
  "Callable entry point to the application."
  [data]
  (println (str "The length of the input string is: " (strlen (or (:user-input data) "")))))

(defn -main
  "Count the length of the input string"
  [& args]
  (process-input {:user-input (first args)}))
