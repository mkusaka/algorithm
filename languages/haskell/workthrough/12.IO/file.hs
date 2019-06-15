import System.IO

main :: IO()

main = do
  handle <- openFile "foo.txt" ReadMode
  text <- hGetContents handle
  putStr text
  hClose handle
