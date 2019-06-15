class Functor t where
  fmap :: (a -> b) -> t a -> t b

f x = 2 * x

main = do
  print $ fmap f (Just 5)
  print $ fmap f Nothing

