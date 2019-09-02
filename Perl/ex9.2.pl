use strict;
$| = 1; #Auto-flush STDOUT

while(<>) {
	if ( /=item\s+([a-z_]\w*)/i ) {
		print "$1\n";
	}	
}	