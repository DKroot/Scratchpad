use strict;
$| = 1; #Auto-flush STDOUT

while(<>) {
	chomp;
	if(/fred/) {
		print "Matched: |$`<$&>$'|\n";
	} else {
		print "No match.\n";
	}		
}	