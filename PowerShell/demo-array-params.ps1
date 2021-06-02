function foo($Param1, $Param2="*.*") {
    echo "#1:", $Param1
    echo "#2:", $Param2
    
    robocopy 'M:\Users\DK\Library\Application Support\Firefox\Profiles\FxProfile' 'C:\Users\DK\FxProfile' $Param2 /XO /PURGE /L
}

foo 'Parameter 1' places*.*, session.rdf, stylish.*
foo 'Parameter 1' 'places*.* session.rdf stylish.*'