main = do
  print "HELLO"
-- Q2.2
inc n = n + 1

double n = n * 2

square n = n * n

-- Q2.3
cond' n = if even n
          then n - 2
          else 3 * n -1

-- Q3.1
sumSquareOrSquareSum x y = (\sum suq -> if sum > suq then sum else suq) (x^2 + y^2) (x + y)^2

-- Q3.2
counter x = (\y -> (\z -> z + 1) (y + 1) ) x


-- Q6.1 (write your own repeat function)
myRepeat repeatNumber repeatedElement = take repeatNumber (cycle [repeatedElement])
myRepeat2 repeatNumber repeatedElement = take repeatNumber [repeatedElement, repeatedElement..]

-- Q6.2
mySubseq startIndex endIndex targetArray = drop startIndex (take (endIndex + 1) targetArray)

-- Q6.3
isFirstHalf e arr = if e `elem` firstHalf
                    then True
                    else False
                    where firstHalf = take (quot (length arr) 2) arr

