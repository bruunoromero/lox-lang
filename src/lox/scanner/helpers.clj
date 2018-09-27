(ns lox.scanner.helpers
  (:require [lox.utils.list :as l]))

(defrecord Token
  [type text literal line])

(defn current-char [scanner]
  (-> scanner
    (:source)
    (nth (:current scanner))
    (str)))

(defn advance [scanner]
  (update-in scanner [:current] inc))

(defn peek
  ([scanner] (peek scanner 1))
  ([scanner amount]
   (loop [scanner scanner
          amount amount]
     (if (>= 0 amount)
       (current-char scanner)
       (recur (advance scanner) (dec amount))))))

(defn end? [scanner]
  (>= (:current scanner) (count (:source scanner))))

(defn match? [scanner expected]
  (and
    (not (end? scanner))
    (= expected (current-char scanner))))

(defn text [scanner]
  (l/slice
    (:source scanner)
    (:start scanner)
    (:current scanner)))

(defn add-token
  ([scanner type] (add-token scanner type nil))
  ([scanner type literal]
   (update-in scanner [:tokens] conj (Token. (text scanner) type literal (:line scanner)))))