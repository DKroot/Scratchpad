#
# Windows only
#
require 'watir'

# Patch Watir for better compatibility with Watir-WebDriver
require 'watir/element_collections'
Watir::ElementCollections.class_eval do
  alias_method :original_array_op, :[]

  # Zero-based array operator
  def [](n)
    puts "get #{self.inspect}[#{n}]"
    return original_array_op(n+1)
  end
end

require 'watir/container'
require 'watir/element'
require 'watir/table'
Watir::TableRow.class_eval do
  alias_method :original_array_op, :[]

  # Zero-based array operator
  def [](n)
    puts "get #{self.inspect}[#{n}]"
    return original_array_op(n+1)
  end
end

browser = Watir::IE.new_window
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