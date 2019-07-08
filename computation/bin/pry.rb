# /usr/bin/env ruby
require 'pry'

Dir.glob("./SIMPLE/**/*.rb").each do |path|
  require path
end

binding.pry
