data Shape = Rect Double Double
              | Tri Double Double

area :: Shape -> Double
area (Rect x y) = x * y
area (Tri x y) = x * y / 2

main = do
  print $ area ( Rect 3 4 )
  print $ area ( Tri 5 6 )
