(ns lox.utils.list-test
  (:require [clojure.test :refer :all]
            [lox.utils.list :as l]))

(deftest slice
  (testing "slice takes a <collection>, [start] and [end] and returns a portion of the original collection"
    (let [portion (l/slice '(1 2 3 4 5 6) 1 4)]
      (is (= portion '(2 3 4))))))