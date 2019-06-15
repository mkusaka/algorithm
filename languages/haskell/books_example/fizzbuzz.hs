module Main (main) where
  import Control.Monad (when)

  main :: IO ()
  main = foldr f ( return () ) ( map fizzbuzz [1..20] )
    where
      fizzbuzz n | n `mod` 15 == 0 = "FizzBuzz"
                 | n `mod` 3 == 0  = "Buzz"
                 | n `mod` 5 == 0  = "Fizz"
                 | otherwise       = show n
      f str act = do
              putStrLn str
              act
