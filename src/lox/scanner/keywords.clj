(ns lox.scanner.keywords
  (:require
    [lox.scanner.helpers :as h]))

(defonce keywords
  {"and" :and
   "class" :class
   "else" :else
   "false" :false
   "for" :for
   "fun" :fun
   "if" :if
   "nil" :nil
   "or" :or
   "print" :print
   "return" :return
   "super" :super
   "this" :this
   "true" :true
   "var" :var
   "while" :while})

(defn add-keyword [scanner]
  (let [text (h/text scanner)
        type (get keywords text)]
    (when type
      (h/add-token scanner type))))

