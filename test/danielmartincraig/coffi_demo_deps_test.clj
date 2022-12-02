(ns danielmartincraig.coffi-demo-deps-test
  (:require [clojure.test :refer :all]
            [danielmartincraig.coffi-demo-deps :refer :all]))

(deftest test-my-demo 
  (testing ""
    (is (strlen "Hello World") 11)))