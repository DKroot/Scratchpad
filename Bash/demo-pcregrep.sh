#!/usr/bin/env bash
set -e
set -o pipefail

# `${USER:-${USERNAME:-${LOGNAME}}}` might be not available inside Docker containers
echo -e "\n# demo-grep.sh: running under $(whoami)@${HOSTNAME} in ${PWD} #\n"

readonly MSG="2021-11-22 | 07:58:53.238 | ERROR | 0.1-4226-exec-5 | o.g.jersey.server.ServerRuntime$Responder.writeResponse() : An I/O error has occurred while writing a response message entity to the container output stream.

org.glassfish.jersey.server.internal.process.MappableException: org.apache.catalina.connector.ClientAbortException: java.io.IOException: Connection reset by peer
	at org.glassfish.jersey.server.internal.MappableExceptionWrapperInterceptor.aroundWriteTo(MappableExceptionWrapperInterceptor.java:67)
	at java.base/java.lang.Thread.run(Thread.java:829)
Caused by: org.apache.catalina.connector.ClientAbortException: java.io.IOException: Connection reset by peer
	at org.apache.catalina.connector.OutputBuffer.realWriteBytes(OutputBuffer.java:351)
	at org.glassfish.jersey.server.internal.MappableExceptionWrapperInterceptor.aroundWriteTo(MappableExceptionWrapperInterceptor.java:61)
	... 95 common frames omitted
Caused by: java.io.IOException: Connection reset by peer
	at java.base/sun.nio.ch.FileDispatcherImpl.write0(Native Method)
	at org.apache.catalina.connector.OutputBuffer.realWriteBytes(OutputBuffer.java:339)
	... 122 common frames omitted

2021-11-22 | 09:05:51.404 | ERROR | .1-4226-exec-12 | g.n.c.i.rest.UnexpectedExceptionMapper.toResponse() : An unexpected internal server error (500) has been caused by:

java.lang.RuntimeException: java.lang.IllegalArgumentException: Unexpected role: EMP
	at itas.model.dashboard.Dashboard.<init>(Dashboard.java:102)
	at gov.nih.cit.itasng.rest.aon.DashboardResource.render(DashboardResource.java:84)
	at java.base/java.lang.Thread.run(Thread.java:829)
Caused by: java.lang.IllegalArgumentException: Unexpected role: EMP
	at itas.model.dashboard.Dashboard.<init>(Dashboard.java:66)
	... 112 common frames omitted
"

echo 'Searching for known multi-line errors'
echo '-----'
# This match includes the trailing blank line
echo "$MSG" | pcregrep --multiline '(?s)\| ERROR \|.*Caused by: java\.io\.IOException: Connection reset by peer.*?^\n'
echo '-----'

echo -e '\nSearching for unknown multi-line errors'
echo '-----'
# `--invert-match --multiline` with `^\n` or `^$` excludes the line following the RegExp match
echo "$MSG" | pcregrep --invert-match --multiline '(?s)\| ERROR \|.*Caused by: java\.io\.IOException: Connection reset by peer.*?^$'
echo '-----'

