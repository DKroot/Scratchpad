use strict;
$| = 1; #Auto-flush STDOUT

my %count;

chomp(my @words = <STDIN>);
foreach my $word (@words) {
    $count{${word}} += 1;
}
foreach my $word (sort(keys(%count))) {
	print "$word : $count{${word}} time(s)\n"
}	
