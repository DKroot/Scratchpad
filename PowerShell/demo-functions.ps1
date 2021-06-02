function f {
    'foo'
    echo 'bar'
}

$var = f

"``var`` is an array of size=$($var.Length)"
$var.GetType()

''
'--'
$var
'--'
''
'Done.'