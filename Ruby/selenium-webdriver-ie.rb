require 'selenium-webdriver'
driver = Selenium::WebDriver.for :ie
driver.navigate.to "http://google.com"
if driver.current_url.include?("google.com")
  puts "Navigated to Google"
end
driver.navigate.to "http://apple.com"
if driver.current_url.include?("apple.com")
  puts "Navigated to Apple"
end
driver.close