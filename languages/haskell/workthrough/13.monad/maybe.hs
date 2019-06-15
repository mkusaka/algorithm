div2 :: Int -> Maybe Int
div2 x = if even x then Just ( x `div` 2)
          else Nothing

div8 :: Int -> Maybe Int
div8 x = return x >>= div2 >>= div2 >>= div2

main = do
  print $ div8 32
  print $ div8 50

{--
div8 :: Int -> Maybe Int
div8 x =
  case return x of
    Nothing -> Nothing
    Just y ->
      case div2 y of
        Nothing -> Nothing
        Just z ->
          case div2 z of
            Nothing -> Nothing
            Just w -> div2 w
--}
