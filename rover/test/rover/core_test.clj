(ns rover.core-test
  (:require [clojure.test :refer :all]
            [rover.core :refer :all]))

(def position {:x 1 :y 1})
(def test-rover {:coordinate position :bearing :north})

(defn rover [direction]
  (assoc test-rover :bearing direction))

(deftest north-rover-faces-east-after-turning-right
  (is (= (rover :east) (turn-right (rover :north)))))

(deftest east-rover-faces-south-after-turning-right
  (is (= (rover :south) (turn-right (rover :east)))))
