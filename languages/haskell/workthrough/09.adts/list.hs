data ListLike a = Nil | Cons a(ListLike a)

length' :: ListLike a -> Int
length' Nil = 0
length'(Cons x xs) = 1 + length' xs

main = do
  print $ length' Nil
  print $ length' $ Cons 1(Cons 3( Cons 3 Nil))
