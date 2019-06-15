-- data Person = Person String Int -- Person name age

data Person = Person { name :: String, age :: Int }

taro = Person { name = "Taro", age = 35 }

haneko = Person { age = 99, name = "Haneko" }

main = do
  print $ name taro
  print $ age haneko
