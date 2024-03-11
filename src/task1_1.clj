(ns task1-1)

(defn append-letter
  "Appends letter to the end of the seq if the last letter of string is not the same"
  [seq letter]
  {:pre [(some? seq) (some? letter)]}
  (if (.endsWith seq letter) nil (str seq letter)))         ;returning appended string if the last char differs from the new one

(defn append-letters
  "Returns all possible one-letter extensions for a give seq"
  ([seq alphabet]
   {:pre [some? seq]}
   (if (empty? alphabet)                                    ;recursion exit condition
     `()

     (let [extended-seq (append-letter seq (first alphabet)) ;extending seq by first letter of alphabet
           rest-alphabet-extensions (append-letters seq (rest alphabet))] ;all other symbols from alphabet extensions
       (if (some? extended-seq)
         (cons extended-seq rest-alphabet-extensions)

         rest-alphabet-extensions)))))

(defn append-seq
  "Returns all string of fixed size from given alphabet without two identical consecutive symbols"
  ([sequences alphabet n cur-len]
   {:pre [some? sequences]}
   (if (empty? sequences)                                   ;second recursion branch exit condition
     `()

     (if (= cur-len n)                                      ;first recursion branch exit condition
       sequences

       (let [unique-alphabet (set alphabet)
             seq-extensions (append-letters (first sequences) unique-alphabet)]
         (concat (append-seq seq-extensions unique-alphabet n (+ cur-len 1)) (append-seq (rest sequences) unique-alphabet n cur-len))))))

  ([alphabet n] (append-seq (list "") alphabet n 0)))       ;initial function call


(println (append-seq (list "a") 2))