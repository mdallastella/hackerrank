(ns diagonal-difference
  "Given a square matrix of size NxN, calculate the absolute difference
  between the sums of its diagonals.")

(use '[clojure.string :only (split triml)])

;;  0 1 2 3 4 5 6  7  8
;; 11 2 4 4 5 6 10 8 -12

(let [n_t (read-line)
      n (Integer/parseInt n_t)]
  (let [a (for [a_temp (range n)]
            (map #(Integer/parseInt %)
                 (split (read-line) #"\s+")))
        ;; Transform into a vector matrix
        matrix (into [] (map #(into [] %) a))
        ;; Calculate diagonals coords
        first-coords (for [i (range n)] [i i])
        second-coords (for [i (range n)] [(- n i 1) i])
        ;; Get values form the matrix
        first-diag (map #(get-in matrix %) first-coords)
        second-diag (map #(get-in matrix %) second-coords)
        ;; Sum the values
        first-sum (apply + first-diag)
        second-sum (apply + second-diag)]
    ;; Print the result
    (prn (Math/abs (- first-sum second-sum)))))
