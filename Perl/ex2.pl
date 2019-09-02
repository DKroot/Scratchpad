use strict;
$| = 1; #Auto-flush STDOUT
my ($pi, $r) = 3.141592654;

print "Enter radius: \n";
$r = <STDIN>;
print 2 * $pi * $r . "\n"

