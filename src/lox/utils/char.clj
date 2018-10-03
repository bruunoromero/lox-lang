(ns lox.utils.char)

(defn period? [char]
  (= char \.))

(defn alpha? [char]
  (when char
    (or (= \_ char)
        (Character/isLetter char))))

(defn digit? [char]
  (when char
    (Character/isDigit char)))

(defn alpha-numeric? [char]
  (or (alpha? char)
      (digit? char)))