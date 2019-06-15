pwer :: Int -> Double -> Double
pwer 0 _ = 1.0
pwer x y = y * pwer (x-1) y

main = print $ pwer 8 2.0
