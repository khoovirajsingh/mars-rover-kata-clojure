(ns rover.core
  (:gen-class))

(def rotations
  {:north {:right :east :left :west}
   :east {:right :south :left :north}
   :south {:right :west :left :east}
   :west {:right :north :left :south}})

(def translations
  {:north {:delta-x 0 :delta-y 1}
   :south {:delta-x 0 :delta-y -1}
   :east {:delta-x 1 :delta-y 0}
   :west {:delta-x -1 :delta-y 0}})

(defn turn [rover direction]
  (let [bearing (rover :bearing)]
    (assoc rover :bearing ((rotations bearing) direction))))

(defn move [rover]
  (let [bearing (rover :bearing)
        x ((rover :coordinate) :x)
        y ((rover :coordinate) :y)
        delta-x ((translations bearing) :delta-x)
        delta-y ((translations bearing) :delta-y)]
    (assoc rover :coordinate {:x (+ x delta-x) :y (+ y delta-y)})))

(defn execute [rover command]
  (case command
    "R" (turn rover :right)
    "L" (turn rover :left)))


