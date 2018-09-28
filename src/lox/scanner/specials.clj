(ns lox.scanner.specials
  (:require [lox.scanner.helpers :as h]))

(defn advance-and-add [scanner type]
  (-> scanner
    (h/advance)
    (h/add-token type)))

(defn left-paren [scanner]
  (h/add-token scanner :left-paren))

(defn right-paren [scanner]
  (h/add-token scanner :right-paren))

(defn left-brace [scanner]
  (h/add-token scanner :left-brace))

(defn right-brace [scanner]
  (h/add-token scanner :right-brace))

(defn comma [scanner]
  (h/add-token scanner :comma))

(defn dot [scanner]
  (h/add-token scanner :dot))

(defn minus [scanner]
  (h/add-token scanner :minus))

(defn plus [scanner]
  (h/add-token scanner :plus))

(defn semi-colon [scanner]
  (h/add-token scanner :semi-colon))

(defn star [scanner]
  (h/add-token scanner :star))

(defn bang-or-bang-equal [scanner]
  (if (= (h/peek scanner) \=)
    (advance-and-add scanner :bang-equal)
    (h/add-token scanner :equal)))

(defn equal-or-equal-equal [scanner]
  (if (= (h/peek scanner) \=)
    (advance-and-add scanner :equal-equal)
    (h/add-token scanner :equal)))

(defn less-or-less-equal [scanner]
  (if (= (h/peek scanner) \=)
    (advance-and-add scanner :less-equal)
    (h/add-token scanner :less)))

(defn greater-or-greater-equal [scanner]
  (if (= (h/peek scanner) \=)
    (advance-and-add scanner :greater-equal)
    (h/add-token scanner :greater)))

(defonce special-chars
  {\( left-paren
   \) right-paren
   \{ left-brace
   \} right-brace
   \, comma
   \. dot
   \- minus
   \+ plus
   \; semi-colon
   \* star
   \! bang-or-bang-equal
   \= equal-or-equal-equal
   \< less-or-less-equal
   \> greater-or-greater-equal})

(defn add-special [scanner]
  (let [adder (get special-chars (h/current-char scanner))]
    (when adder
      (adder scanner))))