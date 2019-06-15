data Tuple a b = Tuple a b

fst' :: Tuple a b -> a
fst' (Tuple a _) = a

main = do
  print $ fst' (Tuple 123 456)
  print $ fst' (Tuple "yo" "ya")
