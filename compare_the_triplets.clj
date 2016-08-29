(ns compare-the-triplets)

(use '[clojure.string :only (split triml)])

(defn string-to-int-array
  [s]
  (into []
        (map #(Integer/parseInt %)
             (split s #"\s+"))))

(let [a_values (string-to-int-array (read-line))
      b_values (string-to-int-array (read-line))
      result (map (fn [a b] (compare a b)) a_values b_values)]
  (prn
   (apply + (filter pos? result))
   (* -1 (apply + (filter neg? result)))))
