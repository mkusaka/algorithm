data Point = Pt Double Double deriving Eq
-- data Point = Pt Double Double deriving (Show, Read, Eq)
main = do
  print $ (Pt 1 2) == (Pt 1 2)
  print $ (Pt 1 2) == (Pt 2 3)

