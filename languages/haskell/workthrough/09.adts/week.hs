data DayOfWeek = Mon | Tue | Wed | Thu | Fri | Sat | Sun

holiday :: DayOfWeek -> Bool
holiday Sat = True
holiday Sun = True
holiday _   = False

main = do
  print $ holiday Sun
  print $ holiday Sat
  print $ holiday Fri
