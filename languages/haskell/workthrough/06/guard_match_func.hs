pwer :: Int -> Double -> Double
pwer 0 _ = 1.0
pwer x y | x > 0 = y * pwer (x-1) y
  | otherwise = 1.0 / pwer (-x) y

main = print $ pwer (-3) 2.0
