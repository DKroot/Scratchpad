use strict;
$| = 1; #Auto-flush STDOUT

my @lines = <STDIN>;
print reverse(@lines)