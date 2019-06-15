square :: Int -> Int
square x = x * x

arr = [1,2,3,4,5]

-- main :: IO ()
-- main = do
--   print $ map id arr
--   print $ map succ arr
--   print $ map square arr


twice :: (a -> a) -> a -> a
twice f x = f $ f x

main = do
  print $ twice id 2
  print $ twice succ 2
  print $ twice twice square 2
