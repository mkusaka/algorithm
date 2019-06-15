newtype DigitSting = DigitStr String

atoi :: DigitSting -> Int
atoi(DigitStr xs) = read xs

main = do
  print $ atoi(DigitStr "4524642")
