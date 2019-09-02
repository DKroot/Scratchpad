browser.goto("http://en.wikipedia.org/wiki/Watir")
infobox = browser.table(:class, "infobox vevent")
p infobox.rows
row = infobox.rows[1]
row.cells.each {|cell| p cell.text}
row.each {|cell| p cell.text}

row = infobox.rows[2]
row.cells.each {|cell| p cell.text}
row.each {|cell| p cell.text}
