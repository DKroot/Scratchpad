require 'logger'

log = Logger.new(STDOUT)
old_verbose, $VERBOSE = $VERBOSE, nil # suppress a warning
# Arguments to format: 1. SeverityID, 2. DateTime, 3. pid, 4.SeverityLabel, 5.ProgName, 6. Message
Logger::Formatter::Format = "[%4$-5s %2$s] %6$s\n"
$VERBOSE = old_verbose
log.datetime_format = "%H:%M:%S"

log.debug "$LOAD_PATH = {#{$LOAD_PATH}}"