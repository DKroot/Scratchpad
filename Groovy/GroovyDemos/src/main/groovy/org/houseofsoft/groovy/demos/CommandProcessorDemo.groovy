#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

import org.houseofsoft.groovy.demos.helpers.CommandProcessor
import picocli.CommandLine

// Required for static compilation only
def args = (String[]) binding.getVariable('args')

System.exit(new CommandLine(new CommandProcessor()).execute(args))
