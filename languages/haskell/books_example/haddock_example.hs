-- |Module : Main
-- |
-- | Mainモジュールドキュメント

module Main (main) where
  main :: IO ()
  -- ^main関数
  main = do
    -- コメントコメント
    putStr "hello."
    {-
      これもコメント

      ほげほげ
    -}

    putStrLn "World!"

-- stack haddock haddock_example.hs"
