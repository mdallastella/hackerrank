(ns plus-minus)

(use '[clojure.string :only (split triml)])

;; Given an array of integers, calculate which fraction of its
;; elements are positive, which fraction of its elements are negative,
;; and which fraction of its elements are zeroes, respectively. Print
;; the decimal value of each fraction on a new line.

;; Ex: -4 3 -9 0 4 1

(defn calculate-fraction
  [arr n pred]
  (float
   (/ (count (filter pred arr)) n)))

(defn format-float
  [n]
  (format "%.6f" n))

(let [n_t (read-line)
      n (Integer/parseInt n_t)]
  (let [arr_temp (read-line)
        arr_t (split arr_temp #"\s+")
        arr (map #(Integer/parseInt %) arr_t)]
    (do
      (println (format-float (calculate-fraction arr n pos?)))
      (println (format-float (calculate-fraction arr n neg?)))
      (println (format-float (calculate-fraction arr n zero?))))))
