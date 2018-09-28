(ns lox.scanner.specials-test
  (:require [clojure.test :refer :all]
            [lox.scanner.specials :as spc]
            [lox.scanner.core :as s]))

(deftest add-special
  (testing "add-special should add a token the matches the special string"
    (let [scanner (-> ">="
                       (s/create-scanner)
                       (spc/add-special))
          tokens (:tokens scanner)]
      (is (not (nil? scanner)))
      (is (= (map :type tokens) '(:greater-equal))))))