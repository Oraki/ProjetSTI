(deffunction floor (?x) (round (- ?x 0.5)))
(deffunction // (?x ?y) (floor (/ ?x ?y)))

(deftemplate case-valeur (slot col) (slot ligne) (slot zone) (slot is))

(foreach ?col (create$ 1 2 3 4 5 6 7 8 9)
    (foreach ?ligne (create$ 1 2 3 4 5 6 7 8 9)
        (foreach ?valeur (create$ 1 2 3 4 5 6 7 8 9)
            (assert (case-valeur (col ?col) (ligne ?ligne)
                    (zone (* (+ (// (- ?ligne 1) 3) 1) (+ (// (- ?col 1) 3) 1)))
                    (is ?valeur))))))
