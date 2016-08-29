(ns diagonal-difference)

;; Given a square matrix of size NxN, calculate the absolute difference
;; between the sums of its diagonals.

;; Input Format

;; The first line contains a single integer, . The next lines denote
;; the matrix's rows, with each line containing space-separated
;; integers describing the columns.

;; Output Format

;; Print the absolute difference between the two sums of the matrix's
;; diagonals as a single integer.

;; Sample Input

;; 3
;; 11 2 4
;; 4 5 6
;; 10 8 -12
;; Sample Output
;; 15

;; Explanation

;; The primary diagonal is:
;; 11 5 -12
;; Sum across the primary diagonal: 11 + 5 - 12 = 4
;; The secondary diagonal is:
;; 4 5 10
;; Sum across the secondary diagonal: 4 + 5 + 10 = 19
;; Difference: |4 - 19| = 15

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
