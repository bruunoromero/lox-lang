(ns lox.scanner.core-test
  (:require [clojure.test :refer :all]
            [lox.scanner.core :as s]))

(defonce sample "var a = 10;")

(deftest tokenize
  (testing "tokenize should return the correct list of tokens"
    (let [tokens (s/tokenize sample)
          types (map :type tokens)]
      (is (= types '(:var :identifier :equal :number :semi-colon))))))