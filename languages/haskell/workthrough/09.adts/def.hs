data Baz = Bar Double Double

area :: Baz -> Double
area (Bar x y ) = x * y

main = do
  print $ area (Bar 2 3)
  print $ area (Bar 5 6)
