(ns lox.utils.list)

(defn slice
  ([coll]
   (slice coll 0))
  ([coll start]
   (slice coll start (count coll)))
  ([coll start end]
   (->> coll
        (drop start)
        (take (- end start)))))