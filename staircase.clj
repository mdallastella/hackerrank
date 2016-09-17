(ns hr.staircase
  (require [clojure.string :as s]))

(defn create-steps
  [n formatting]
  (format formatting (s/join (take n (repeat "#")))))

(defn print-staircase
  [coll]
  (print (s/join "\n" coll)))

(let [n (Integer/parseInt (read-line))
      formatting (str "%" n "s")]
  (loop [n n
         result []]
    (if (= n 0)
      (print-staircase (reverse result))
      (recur (dec n)
             (conj result (create-steps n formatting))))))
