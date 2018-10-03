(ns lox.scanner.identifier-test
  (:require
    [lox.scanner.core :as s]
    [clojure.test :refer :all]
    [lox.scanner.identifier :as i]))

(deftest read-identifier
  (testing "read-identifier adds an identifier or keyword if matches, returns nil otherwise"
    (let [scanner (s/create-scanner "test")
          added (i/read-identifier scanner)
          tokens (map :type (:tokens added))]
      (is (not (nil? added)))
      (is (= tokens '(:identifier))))))