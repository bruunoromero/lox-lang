(ns lox.scanner.number
  (:require
    [lox.utils.char :as c]
    [lox.scanner.helpers :as h]))

(defn add-number [scanner]
  (let [text (h/text (h/advance scanner))]
    (h/add-token scanner :number (Double/parseDouble text))))

(defn read-integer [scanner]
  (loop [scanner scanner]
    (if (c/digit? (h/peek scanner))
      (recur (h/advance scanner))
      scanner)))

(defn read-number [scanner]
  (let [start (read-integer scanner)]
    (if (and
          (c/period? (h/peek start))
          (c/digit? (h/peek start 2)))
      (add-number (-> start
                    (h/advance)
                    (read-integer)))
      (add-number start))))
