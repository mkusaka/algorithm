-- div2 :: Int -> Maybe Int
-- div2 x = if even x then Just (x `div` 2)
--                    else Nothing

-- div8 :: Int -> Maybe Int
-- div8 x = do
--   y <- div2 x
--   z <- div2 y
--   div2 z

-- main = do
--   print $ div8 32


import Data.Char

-- main :: IO()
-- main = do
--   s <= getLine
--   let t = map toUpper s
--   if null s then return ()
--   else do
--     putStrLn t
--     main

main :: IO()
main = do
  getLine >>= (\s ->
    let t = map toUpper s in
    if null s then return ()
    else putStrLn t >> main)
