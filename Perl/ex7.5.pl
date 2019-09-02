#Fred and Wilma filter

use strict;
$| = 1; #Auto-flush STDOUT

while(<>) {
	if( /(w|W)ilma.*(f|F)red|(f|F)red.*(w|W)ilma/ ) {
		print;
	}
}
print "\nDone!";
#
