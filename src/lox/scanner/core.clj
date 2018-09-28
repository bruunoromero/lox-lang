(ns lox.scanner.core)

(defrecord Scanner
  [line start current source tokens])

(defn create-scanner [source]
  (Scanner. 1 0 0 source []))

(defn reset-start [scanner]
  (assoc scanner :start (:current scanner)))

(defn tokenize [source]
  (let [scanner (create-scanner source)]
    (:tokens scanner)))