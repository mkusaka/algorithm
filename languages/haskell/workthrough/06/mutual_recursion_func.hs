even' :: Int -> Bool
even' x = x == 0 || odd' (x - 1)

odd' :: Int -> Bool
odd' x = x /= 0 && even' (x - 1)

main :: IO ()
main = do
  print $ even' 0
  print $ even' 1
  print $ even' 2
  print $ even' 3
  print $ even' 4

  print $ odd' 0
  print $ odd' 1
  print $ odd' 2
  print $ odd' 3
  print $ odd' 4
