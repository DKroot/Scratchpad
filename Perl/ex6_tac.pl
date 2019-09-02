use strict;
$| = 1; #Auto-flush STDOUT

my @lines;
while (<>) {
	@lines[my $i++] = $_;
}
print reverse(@lines);	