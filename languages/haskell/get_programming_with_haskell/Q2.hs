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
