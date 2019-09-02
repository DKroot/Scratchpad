# Windows only
#
require 'watir'
require 'win32ole'

@@word=WIN32OLE.new('Word.Application')
@@word.Documents.Add()

def take_a_screenshot(browser, url)
  @autoit = WIN32OLE.new("AutoItX3.Control")
  browser.bring_to_front
  browser.maximize
  @autoit.Send("{PRINTSCREEN}")
  browser.close
  @@word.Selection.Paste
  @autoit.Send("{ENTER}")
end

def save_file
  @@word.ActiveDocument.SaveAs('screenshots.doc')
  @@word.ActiveDocument.close
  @@word.Quit
end

browser = Watir::IE.new_window
browser.goto("http://google.com")
if browser.url.include?("google.com")
  puts "Navigated to Google"
end
take_a_screenshot(browser)

browser.goto("http://apple.com")
if browser.url.include?("apple.com")
  puts "Navigated to Apple"
end
take_a_screenshot(browser)

save_file

browser.close