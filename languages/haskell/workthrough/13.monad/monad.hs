f x = return (2 * x)

main = do
  print $ Just 5 >>= f
  print $ Nothing >>= f
