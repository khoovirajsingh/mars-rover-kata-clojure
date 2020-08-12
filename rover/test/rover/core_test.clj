(ns rover.core-test
  (:require [clojure.test :refer :all]
            [rover.core :refer :all]))

(def position {:x 1 :y 1})
(def rover {:coordinate position :bearing :north})
  

(deftest north-rover-faces-east-after-turning-right
  (is (= {:coordinate position :bearing :east} (turn-right rover))))
