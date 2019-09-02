#
# Windows only
#
require 'watir-webdriver'

# Patch Watir-WebDriver for better compatibility with Watir
Watir::TableRow.class_eval do
  def column_count
    cells.length
  end
end

browser = Watir::Browser.new(:firefox)
browser.goto("http://www.google.com")
if browser.url.include?("google.com")
  puts "Navigated to Google"
end
table = browser.table(:id, "sftab")
if table.exists?
  puts "Located the table"
end
row = table.rows[0] # first row
if row.exists?
  puts "Located the row"
end
p row
puts "Columns : #{row.column_count}"