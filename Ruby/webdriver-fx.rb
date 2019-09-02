require 'watir-webdriver'
browser = Watir::Browser.new(:firefox)
browser.goto("http://google.com")
if browser.url.include?("google.com")
  puts "Navigated to Google"
end
browser.goto("http://apple.com")
if browser.url.include?("apple.com")
  puts "Navigated to Apple"
end
browser.close