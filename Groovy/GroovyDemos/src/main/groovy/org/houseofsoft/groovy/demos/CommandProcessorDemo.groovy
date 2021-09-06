#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

import org.houseofsoft.groovy.demos.helpers.AppOptions
import picocli.CommandLine

// Required for static compilation only
def args = (String[]) binding.getVariable('args')

AppOptions appOptions = []
CommandLine cli = [appOptions]
cli.parseArgs(args)
println "Parsed CLI options: ${appOptions}"

println "## Usage help ##"
cli.usage(System.out)
