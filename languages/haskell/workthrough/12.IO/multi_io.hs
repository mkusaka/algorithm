main :: IO()

main = do
  putStrLn "What's your name?"
  name <- getLine
  let greeting = "Hello, " ++ name ++ "!"
  putStrLn greeting

