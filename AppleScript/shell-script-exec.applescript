-- Load logger as the parent script to enable correct script name rendering
property parent : load script file ((path to scripts folder from user domain as text) & "logger.scpt")

script Env
	try
		do shell script ("set >> /tmp/shell-script-exec.log")
		system_log("Success")
	on error errString number errorNumber
		system_log(errString)
	end try
end script

system_log("Started")
run Env
system_log("Done")
