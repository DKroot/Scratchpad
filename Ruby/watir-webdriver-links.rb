require 'watir-webdriver'

browser = Watir::Browser.new(:firefox)
browser.goto("http://google.com")
if browser.url.include?("google.com")
  puts "Navigated to Google"
end
for link in browser.links
  puts "#{link.text} #{link.to_s}"
end
browser.close