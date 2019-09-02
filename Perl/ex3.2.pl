use strict;
$| = 1; #Auto-flush STDOUT

my @names = qw ( fred betty barney dino );
my (@numbers, $i);

chomp(@numbers = <STDIN>);
foreach $i (@numbers) {
	print "#$i = $names[$i-1]\n"
}	
