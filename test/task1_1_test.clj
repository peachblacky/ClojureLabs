(ns task1-1-test
  (:require
    [clojure.test :as test])
  (:use [task1-1 :only (append-seq)]))


(test/deftest task1-1-test
  (test/testing "Testing task1-1"
    (test/is (= (append-seq (list "a", "b", "c") 1) (list "a" "b" "c")))
    (test/is (= (append-seq (list "a", "b", "c") 3) (list "aba" "abc" "aca" "acb" "bab" "bac" "bca" "bcb" "cab" "cac" "cba" "cbc")))
    (test/is (= (append-seq (list "a", "b", "c", "d") 2) (list "ab" "ac" "ad" "ba" "bc" "bd" "ca" "cb" "cd" "da" "db" "dc")))
    ))

