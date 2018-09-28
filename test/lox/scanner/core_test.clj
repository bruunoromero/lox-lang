(ns lox.scanner.core-test
  (:require [clojure.test :refer :all]
            [lox.scanner.core :as s]))

(defonce sample "var a = 10;")

(deftest reset-start
  (testing "reset-start sets the start value of a scanner to be the current value of a scanner"
    (let [scanner (-> sample
                       (s/create-scanner)
                       (assoc :current 2)
                       (s/reset-start))]
      (is (= (:start scanner) 2)))))

(deftest tokenize
  (testing "tokenize should return the correct list of tokens"
    (let [tokens (s/tokenize sample)
          types (map :type tokens)]
      (is (= types '(:var :identifier :equal :number :semi-colon))))))