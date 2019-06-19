main = do
  print "HELLO"

-- Q3.1
sumSquareOrSquareSum x y = (\sum suq -> if sum > suq then sum else suq) (x^2 + y^2) (x + y)^2

-- Q3.2
counter x = (\y -> (\z -> z + 1) (y + 1) ) x
