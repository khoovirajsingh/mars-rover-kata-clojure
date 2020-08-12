(ns rover.core
  (:gen-class))

(def rotations
  {:north {:right :east}
   :east {:right :south}
   :south {:right :west}
   :west {:right :north}})

(defn turn-right [rover]
  (let [bearing (rover :bearing)]
    (assoc rover :bearing ((rotations bearing) :right))))


