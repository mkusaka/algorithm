require "mini-smtp-server"
# Create a new server instance listening at 127.0.0.1:2525
# and accepting a maximum of 4 simultaneous connections

# This is an SMTP server that logs all
# the messages it receives to STDOUT
class StdoutSmtpServer < MiniSmtpServer

  def new_message_event(message_hash)
    puts "# New email received:"
    puts "-- From: #{message_hash[:from]}"
    puts "-- To:   #{message_hash[:to]}"
    puts "--"
    puts "-- " + message_hash[:data].gsub(/\r\n/, "\r\n-- ")
    puts
  end

end

server = StdoutSmtpServer.new(2525, "127.0.0.1", 4)

# Start the server
server.start

server.join

# ...
# serving requests & doing other work here
# ...

# # Shutdown the server without interrupting any connections:
# server.shutdown
# while(server.connections > 0)
#   sleep 0.01
# end
# server.stop
# server.join
