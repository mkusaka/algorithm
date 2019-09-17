iteration = (ARGV[0] || 1000).to_i

iteration.times do |i|
  system("curl localhost:3000/#{i}")
end
