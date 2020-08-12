(ns rover.core
  (:gen-class))

(defn turn-right [rover]
  (assoc rover :bearing :east))

