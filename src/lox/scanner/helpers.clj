(ns lox.scanner.helpers
  (:require [lox.utils.list :as l]))

(defrecord Token
  [text type literal line])

(defn current-char [scanner]
  (-> scanner
    (:source)
    (nth (:current scanner))))

(defn advance [scanner]
  (update-in scanner [:current] inc))

(defn end? [scanner]
  (>= (:current scanner) (count (:source scanner))))

(defn peek
  ([scanner] (peek scanner 1))
  ([scanner amount]
   (loop [scanner scanner
          amount amount]
     (cond
       (end? scanner) \0
       (>= 0 amount) (current-char scanner)
       :else (recur (advance scanner) (dec amount))))))

(defn text [scanner]
  (apply str (l/slice
               (:source scanner)
               (:start scanner)
               (:current scanner))))

(defn add-token
  ([scanner type] (add-token scanner type nil))
  ([scanner type literal]
   (let [advanced (advance scanner)]
     (update-in advanced [:tokens] conj (Token. (text advanced) type literal (:line advanced))))))