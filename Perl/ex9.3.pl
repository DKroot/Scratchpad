use strict;
$| = 1; #Auto-flush STDOUT

my %count;
while(<>) {
	if ( /=item\s+([a-z_]\w*)/i ) {
		$count{$1} += 1;
	}	
}
foreach my $key (sort(keys(%count))) {
	if ( $count{$key} >= 3) {
		print "$key : $count{$key}\n";
	}	
}	
