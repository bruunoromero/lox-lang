(ns lox.scanner.helpers)

(defn current-char [scanner]
  (-> scanner
    (:source)
    (nth (:current scanner))
    (str)))