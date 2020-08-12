(ns rover.core
  (:gen-class))

(def rotations
  {:north {:right :east :left :west}
   :east {:right :south :left :north}
   :south {:right :west :left :east}
   :west {:right :north :left :south}})

(defn turn [rover direction]
  (let [bearing (rover :bearing)]
    (assoc rover :bearing ((rotations bearing) direction))))

(defn turn-left [rover]
  (let [bearing (rover :bearing)]
    (assoc rover :bearing ((rotations bearing) :left))))


