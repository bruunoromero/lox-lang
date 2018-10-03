(ns lox.scanner.helpers
  (:require [lox.utils.list :as l]))

(defrecord Token
  [text type literal line])

(defn advance [scanner]
  (update-in scanner [:current] inc))

(defn end? [scanner]
  (>= (:current scanner) (count (:source scanner))))

(defn current-char [scanner]
  (when (not (end? scanner))
    (-> scanner
        (:source)
        (nth (:current scanner)))))

(defn text [scanner]
  (apply str (l/slice
               (:source scanner)
               (:start scanner)
               (:current scanner))))

(defn peek
  ([scanner] (peek scanner 1))
  ([scanner amount]
   (loop [scanner scanner
          amount amount]
     (cond
       (end? scanner) nil
       (>= 0 amount) (current-char scanner)
       :else (recur (advance scanner) (dec amount))))))

(defn add-token
  ([scanner type] (add-token scanner type nil))
  ([scanner type literal]
   (let [advanced (advance scanner)]
     (update-in advanced [:tokens] conj (Token. (text advanced) type literal (:line advanced))))))