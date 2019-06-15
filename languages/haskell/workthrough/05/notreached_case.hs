getValue defValue maybe =
  case maybe of
    _ -> defValue
    Just x -> x

main = do
  print (getValue 0 Nothing)
  print (getValue "key" (Just "value"))
  print (getValue 77 Nothing)
  print (getValue "foooo" (Just "bar baz"))

-- ```
-- 5/notreached_case.hs:4:5: warning: [-Woverlapping-patterns]
--   Pattern match is redundant
--   In a case alternative: Just x -> ...
-- ```
