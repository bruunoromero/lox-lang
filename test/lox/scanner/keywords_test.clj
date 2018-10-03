(ns lox.scanner.keywords-test
  (:require
    [lox.scanner.core :as s]
    [clojure.test :refer :all]
    [lox.scanner.keywords :as k]
    [lox.scanner.helpers :as h]))

(deftest add-keyword
  (testing "add-keyword takes a scanner and if it text is a keywords it adds to tokens otherwise it returns nil"
    (let [scanner (s/create-scanner "and")
          advanced (assoc scanner :current 3)
          added (k/add-keyword advanced)
          tokens (map :type (:tokens added))]
      (is (not (nil? added)))
      (is (= tokens '(:and))))))