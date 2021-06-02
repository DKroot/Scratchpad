"Starting with $global:ErrorActionPreference = 'Stop' which should be always set (in a PS profile)"
'Erroring out'
foo
'Done.'

trap { 
  ''
  'Failed!'
  # Write-Error would terminate immediately with $global:ErrorActionPreference = 'Stop'
  #Write-Error $Error[0]
  # `Get-Error` is not available for some reason
  #Get-Error -Newest
  'Re-throwing the error'
  throw $Error[0]
}