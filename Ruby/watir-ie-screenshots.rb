# Windows only
#

require 'watir'
require 'win32ole'

@browser = Watir::IE.new_window
@autoit = WIN32OLE.new("AutoItX3.Control")
@word = WIN32OLE.new('Word.Application')
@word.Documents.Add

def take_a_screenshot
  @browser.bring_to_front
  @browser.maximize
  @autoit.Send("{PRINTSCREEN}")
  sleep 0.5 # Need some delay for screen to be copied
  @word.Selection.Paste
  @autoit.Send("{ENTER}")
end

def save_file
  @word.ActiveDocument.SaveAs('screenshots.doc') # Will be dumped into user's Documents folder
  @word.ActiveDocument.Close
  @word.Quit
end

@browser.goto("http://google.com")
if @browser.url.include?("google.com")
  puts "Navigated to Google"
end
take_a_screenshot

@browser.goto("http://apple.com")
if @browser.url.include?("apple.com")
  puts "Navigated to Apple"
end
take_a_screenshot

save_file

@browser.close

=begin
require 'watir'
require 'win32ole'

@@word=WIN32OLE.new('Word.Application')
@@word.Documents.Add()

def take_a_screenshot(url)
  @autoit = WIN32OLE.new("AutoItX3.Control")
  browser = Watir::IE.new
  browser.bring_to_front
  browser.goto(url)
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

take_a_screenshot('http://www.agiletester.co.uk')
take_a_screenshot('http://www.fsf.org/')
save_file
=end