(ns lox.scanner.number-test
  (:require
    [lox.scanner.core :as s]
    [clojure.test :refer :all]
    [lox.scanner.number :as n]))

(deftest read-number
  (testing "read-number takes an scanner and adds a number tokens if found"
    (let [scanner (s/create-scanner "1.")
          added (n/read-number scanner)
          types (map :type (:tokens added))
          literals (map :literal (:tokens added))]
      (is (= '(:number) types))
      (is (= '(1.0) literals)))))