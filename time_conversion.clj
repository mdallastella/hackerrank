(ns time-conversion
  "Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
  Note: Midnight is 12:00:00AM on a 12-hour clock, and 00:00:00 on a
  24-hour clock. Noon is on a -hour clock, and on a -hour clock.")

(use '[clojure.string :only (split triml)])

(defn split-time
  [t]
  (re-find #"(\d+):(\d+):(\d+)(\S+)" t))

(defn to-24-hours
  [t]
  (let [hours (rem (Integer/parseInt (nth t 1)) 12)
        [_ _ min sec _] t
        ampm (last t)
        ends-with-pm? (.endsWith ampm "PM")
        format-time (fn [h m s] (str (format "%02d" h) ":" m ":" s))]
    (if ends-with-pm?
      (format-time (+ 12 hours) min sec)
      (format-time hours min sec))))

(let [time (read-line)
      time-24-hours (to-24-hours (split-time time))]
  (println time-24-hours))
