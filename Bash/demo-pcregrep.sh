#!/usr/bin/env bash
set -e
set -o pipefail

# Get a script directory, same as by $(dirname $0)
readonly SCRIPT_DIR=${0%/*}
#readonly ABSOLUTE_SCRIPT_DIR=$(cd "${SCRIPT_DIR}" && pwd)
#
#readonly WORK_DIR=${1:-${ABSOLUTE_SCRIPT_DIR}/build} # $1 with the default
#if [[ ! -d "${WORK_DIR}" ]]; then
#  mkdir "${WORK_DIR}"
#  chmod g+w "${WORK_DIR}"
#fi
#cd "${WORK_DIR}"

# `${USER:-${USERNAME:-${LOGNAME}}}` might be not available inside Docker containers
echo -e "\n# demo-grep.sh: running under $(whoami)@${HOSTNAME} in ${PWD} #\n"

# shellcheck disable=SC2016 # false positive
readonly MSG='2021-11-22 | 12:58:37.051 | ERROR | 0.1-4226-exec-3 | g.n.c.i.rest.lao.ApproveTeleworkResource.validateAndProcess() : java.lang.Exception: Payroll  Error -- Payroll Update Failed, please contact IT Service Desk.
2021-11-22 | 12:59:07.058 | ERROR | 0.1-4226-exec-8 | g.n.c.i.rest.lao.ApproveTeleworkResource.validateAndProcess() : java.lang.Exception: Payroll  Error -- Payroll Update Failed, please contact IT Service Desk.
2021-11-22 | 13:14:11.649 | ERROR | .1-4226-exec-16 | itas.old.ITASCommonDB.CDBExecStatement() : Error executing the following statement: dbo.prc_L_ReportParamSel  '003362930', 'CON'
2021-11-22 | 13:14:11.649 | ERROR | .1-4226-exec-16 | itas.old.ITASCommonDB.CDBExecStatement() :

	at com.ddtek.jdbc.sqlserverbase.ddco.a(Unknown Source)
	at java.base/java.lang.Thread.run(Thread.java:829)

2021-11-22 | 07:58:53.238 | ERROR | 0.1-4226-exec-5 | o.g.jersey.server.ServerRuntime$Responder.writeResponse() : An I/O error has occurred while writing a response message entity to the container output stream.

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
'

echo 'Input text'
echo '----------'
echo "$MSG"
echo '----------'

echo -e '\nSearching for known multi-line errors'
echo '----------'
# `^\n` includes the matching blank line, `^$` just anchors on the blank line, but excludes it
echo "$MSG" | pcregrep --multiline "--file=$SCRIPT_DIR/demo-pcregrep-known-errors.txt"
echo '----------'

echo -e '\nSearching for unknown multi-line errors'
echo '----------'
# `--invert-match --multiline` with `^\n` or `^$` excludes the extra next line following the positive match itself
echo "$MSG" | pcregrep --invert-match --multiline "--file=$SCRIPT_DIR/demo-pcregrep-known-errors.txt" || :
echo '----------'

