use strict;
$| = 1; #Auto-flush STDOUT

sub total {
    my @list = @_;
    my($total, $num) = 0;
	foreach $num (@list) {
	   $total += $num;             
	}
	return $total;
}	

print "Sum of 1 to 1000 = " . &total(1..1000)