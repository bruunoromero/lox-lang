(ns lox.scanner.identifier
  (:require
    [lox.utils.char :as c]
    [lox.scanner.helpers :as h]
    [lox.scanner.keywords :as k]))

(defn read-identifier [scanner]
  (loop [scanner scanner]
    (let [char (h/current-char scanner)]
      (if (c/alpha-numeric? char)
        (recur (h/advance scanner))
        (or (k/add-keyword scanner)
            (h/add-token scanner :identifier))))))