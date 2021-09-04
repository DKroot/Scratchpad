#!/usr/bin/env groovy
@Grab('info.picocli:picocli-groovy:4.6.1')
package gov.nih.cit.itasintng

import picocli.CommandLine

System.exit(new CommandLine(new CommandProcessor()).execute(args))
