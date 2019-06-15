data Ratio = Integer :/ Integer

ratioToFloat :: Ratio -> Float
ratioToFloat(x :/ y) = fromIntegral x / fromIntegral y

main = do
  print $ ratioToFloat(3 :/ 2)
  print $ ratioToFloat(10 :/ 3)
