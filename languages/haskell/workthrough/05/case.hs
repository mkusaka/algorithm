getValue defvalue maybe =
  case maybe of
    Nothing -> defvalue
    Just x -> x

main = do
  print (getValue 0 Nothing)
  print (getValue "key" (Just "value"))
