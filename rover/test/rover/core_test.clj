(ns rover.core-test
  (:require [clojure.test :refer :all]
            [rover.core :refer :all]))

(def position {:x 1 :y 1})
(def test-rover {:coordinate position :bearing :north})

(defn rover [direction]
  (assoc test-rover :bearing direction))

(deftest north-rover-faces-east-after-turning-right
  (is (= (rover :east) (turn (rover :north) :right))))

(deftest east-rover-faces-south-after-turning-right
  (is (= (rover :south) (turn (rover :east) :right))))

(deftest south-rover-faces-west-after-turning-right
  (is (= (rover :west) (turn (rover :south) :right))))

(deftest north-rover-faces-west-after-turning-left
  (is (= (rover :west) (turn (rover :north) :left))))

(deftest north-rover-moves-up
  (is (= {:coordinate {:x 1 :y 2} :bearing :north} (move (rover :north)))))

(deftest north-rover-moves-up-twice
  (is (= {:coordinate {:x 1 :y 3} :bearing :north} (move {:coordinate {:x 1 :y 2} :bearing :north}))))
