data Point = Pt Double Double

instance Eq Point where
  (Pt x y) == (Pt x' y') = x == x' && x == y'

main = do
  print $ (Pt 1 3) == (Pt 2 3)
  print $ (Pt 1 2) /= (Pt 2 3)
  print $ (Pt 1 2) /= (Pt 1 2)
