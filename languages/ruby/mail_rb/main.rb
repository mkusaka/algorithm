# require "mail"

# Mail.deliver do
#   from "hoge@example.com"
#   to "hinoshita1002@gmail.com"
#   subject "test"
#   body "hogehoge"
# end

require 'net/smtp'

message = <<END_OF_MESSAGE
From: YourRubyApp <info@yourrubyapp.com>
To: BestUserEver <hinoshita1002@gmail.com>
Subject: Any email subject you want
Date: Tue, 02 Jul 2019 15:00:34 +0800

Lorem Ipsum
END_OF_MESSAGE
Net::SMTP.start('127.0.0.1', 2525) do |smtp|
  smtp.send_message message,
  'info@yourrubyapp.com',
  'hinoshita1002@gmail.com'
end
