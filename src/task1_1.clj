(ns task1-1)

(defn append-letter
  "Appends letter to the end of the seq if the last letter of string is not the same"
  [^"java.lang.String" seq letter]
  {:pre [(some? seq) (some? letter)]}
  (
    if (.endsWith seq letter)
    nil
    (str seq letter)
    )
  )

(defn append-letters
  "Returns all possible one-letter extensions for a give seq"
  ([seq alphabet]
   {:pre [some? seq]}
   (if (empty? alphabet)
     nil
     (let [extended-seq (append-letter seq (first alphabet))]
       (if (some? extended-seq)
         (cons (append-letter seq (first alphabet)) (append-letters seq (rest alphabet)))
         (append-letters seq (rest alphabet)))
       )
     )
   )
  ([alphabet] alphabet)
  )

(defn append-seq
  "Returns all string of fixed size from given alphabet without two identical consecutive symbols"
  (
   [sequences alphabet n cur-len]
   {:pre [some? sequences]}
   (
     if (empty? sequences)
     nil
     (if (>= cur-len n)
       sequences
       (let [seq-extensions (append-letters (first sequences) alphabet)]
         (concat (append-seq seq-extensions alphabet n (+ cur-len 1)) (append-seq (rest sequences) alphabet n cur-len))
         )
       )
     )
   )

  (
   [alphabet n]
   (append-seq (list "") alphabet n 0)
   )
  )

(let [alphabet (list "a", "b", "c")]
  (println (append-seq alphabet 3))
  )
