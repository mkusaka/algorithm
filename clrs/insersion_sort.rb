#input = [10, 30, 11, 20, 4, 330, 220, 4440, 10, 1, 444, 4423, 8236, 23, 324, 76]
input = [2,1]
(1..(input.length - 1)).each do |idx|
  key = input[idx]
  i = idx - 1
  while i >= 0 && input[i] > key
    input[i + 1] = input[i]
    p i
    i = i - 1
    p i
  end
  input[i + 1] = key
end

p input
