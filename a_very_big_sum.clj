(ns a-very-big-sum)

(use '[clojure.string :only (split triml)])

(let [n_t (read-line)
      n (Integer/parseInt n_t)]
  (let [arr_temp (rsead-line)
        arr_t (split arr_temp #"\s+")
        arr (map #(Integer/parseInt %) arr_t)]
    (prn (apply + arr))))
