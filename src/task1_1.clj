(ns task1-1)

(defn append-letter
  "Append letter to seq"
  [seq letter]
  (
    if (= letter nil)
    seq
    (if (not (.contains seq letter))
      (.concat seq letter)
      seq
      )
    )

  )

(defn append-seq
  "Returns all possible one-letter extensions of given seq to the given len-limit n"
  [sequences alphabet n]
  (
   (let [seq (first sequences)]
     (if (some? seq)
       (let [seq-extensions (cons (append-letter seq (first alphabet)) (append-seq sequences (rest alphabet) n))]
         (if (< (.length seq) n)
           (concat seq-extensions (append-seq (rest sequences) alphabet n))
           seq-extensions
           )
         ;(if (> (.size alphabet) 0)
         ;  (cons (append-letter seq (first alphabet)) (append-seq seq (rest alphabet) n))
         ;  (append-letter seq (first alphabet)))
         )
       )
     (list)
     )
   )
  )

(defn get-seqs
  "Return sequences of length n from letters of given alphabet"
  [n alphabet]
  (

    )
  )

(let [alphabet (list "a", "b", "c")]
  (println (append-seq "" alphabet 3))
  )
