data Person = Person { hobby :: String, age :: Int }

intro :: Person -> String
intro(Person { hobby = n }) = "My hobby is " ++ n ++ "."

inc :: Person -> Person
inc p = p { age = age p + 1 }

who = Person "Run" 44

main = do
  print $ intro who
  print $ age $ inc who
