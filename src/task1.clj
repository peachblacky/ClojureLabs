(ns task1)

(defn append-letter
  "Appends letter to the end of the seq if the last letter of string is not the same"
  [^"java.lang.String" seq letter]
  {:pre [(some? seq) (some? letter)]}
  (
    if (.endsWith seq letter)
    seq
    (+ seq letter)
    )
  )

(defn append-letters
  "Returns all possible one-letter extensions for a give seq"
  [seq alphabet]
  (
    if (nil? seq)
    alphabet
    (
      if (empty? alphabet)
      seq
      (

        )
      )
    )
  )

(defn append-seq
  ""
  [sequences alphabet n]
  (

    )
  )

(let [alphabet (list "a", "b", "c")]
  (println (append-seq (list "") alphabet 3))
  )
