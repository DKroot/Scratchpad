# Windows only
#

require 'watir'

browser = Watir::IE.new_window
browser.goto("http://google.com")
if browser.url.include?("google.com")
  puts "Navigated to Google"
end
for link in browser.links
  puts "#{link.text} #{link.to_s}"
end
begin
  browser.close
rescue => e
  puts "WARNING: Error in closing the browser:\n#{e.message}\n#{e.backtrace}"
end