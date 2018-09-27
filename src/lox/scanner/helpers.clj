(ns lox.scanner.helpers)

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