use strict;
$| = 1; #Auto-flush STDOUT

while(<>) {
	chomp;
	if( /(\b\w+\b)(\s+\b\1\b)+/ ) {
		print "Matched: |$`<$&>$'|\n";
	} else {
		print "No match.\n";
	}		
}	