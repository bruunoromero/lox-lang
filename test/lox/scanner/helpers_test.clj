(ns lox.scanner.helpers-test
  (:require [clojure.test :refer :all]
            [lox.scanner.helpers :as h]
            [lox.scanner.core :as s]))

(deftest current-char
  (testing "current-char should return the current char of a scanner if found"
    (let [scanner (s/create-scanner "var a = 10;")]
      (is "v" (h/current-char scanner)))))

(deftest advance
  (testing "advance should move the pointer to the next char"
    (let [scanner (h/advance (s/create-scanner "var a = 10;"))]
      (is "a" (h/current-char scanner)))))

(deftest peek
  (testing "peek returns the char after the current one if not amount is passed"
    (let [scanner (s/create-scanner "var a = 10;")]
      (is "a" (h/peek scanner))))

  (testing "peek returns the amount of chars after the current one if amount is passed"
    (let [scanner (s/create-scanner "var a = 10;")]
      (is "=" (h/peek scanner 6)))))

(deftest end?
  (testing "end? returns true if scanner is at/after the last position"
    (let [source "var a = 10;"
          scanner (assoc-in (s/create-scanner source) [:current] (count source))]
      (is (true? (h/end? scanner)))))

  (testing "end? returns false if scanner is before the last position"
    (let [scanner (s/create-scanner "var a = 10;")]
      (is (false? (h/end? scanner))))))