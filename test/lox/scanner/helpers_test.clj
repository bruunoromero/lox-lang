(ns lox.scanner.helpers-test
  (:require [clojure.test :refer :all]
            [lox.scanner.helpers :as h]
            [lox.scanner.core :as s]))

(deftest current-char
  (testing "current-char should return the current char of a scanner if found"
    (let [scanner (s/create-scanner "var a = 10;")]
      (is "v" (h/current-char scanner)))))