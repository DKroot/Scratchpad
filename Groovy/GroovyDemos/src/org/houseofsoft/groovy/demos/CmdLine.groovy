#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

@Grab('info.picocli:picocli-groovy:4.6.1')

import picocli.CommandLine
import picocli.CommandLine.Command
import picocli.CommandLine.Option
import picocli.CommandLine.Help
import groovy.transform.Field
import picocli.groovy.PicocliScript2

@Command(header = [//
    $/@|bold,green    ___                       |@/$,
    $/@|bold,green   / __|_ _ ___  _____ ___  _ |@/$,
    $/@|bold,green  | (_ | '_/ _ \/ _ \ V / || ||@/$,
    $/@|bold,green   \___|_| \___/\___/\_/ \_, ||@/$,
    $/@|bold,green                         |__/ |@/$],
    description = 'Command line parsing demo',
    version = 'checksum v1.2.3',
    showDefaultValues = true,
    footerHeading = '%nFor more details, see:%n',
    footer = ['[1] https://docs.oracle.com/javase/9/docs/specs/security/standard-names.html',
        'ASCII Art thanks to http://patorjk.com/software/taag/'])
@PicocliScript2

// @formatter:off
@Option(defaultValue = 'MD5', names = ['-a', '--algorithm'], description = [
    'MD2, MD5, SHA-1, SHA-256, SHA-384, SHA-512,',
    '  or any other MessageDigest algorithm.'])
// @formatter:on
@Field String algorithm

@Option(names = ["-h", "--help"], usageHelp = true, description = 'Show this help message and exit.')
@Field boolean helpRequested

// Positional paremeters
//@Parameters(arity="1", paramLabel="FILE", description="The file(s) whose checksum to calculate.")
//@Field files

println "algorithm=${algorithm}"

//region Render header
CommandLine cmdLine = [this]
print cmdLine.helpSectionMap['header'].render(cmdLine.helpFactory.create(cmdLine.commandSpec, Help.defaultColorScheme(
    Help.Ansi.AUTO)))
//endregion

println "Done"