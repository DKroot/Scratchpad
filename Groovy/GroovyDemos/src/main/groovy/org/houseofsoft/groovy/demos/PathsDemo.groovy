#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

import java.nio.file.Paths
import java.nio.file.Path

def currentDir = Paths.get ''
println "Current directory: `${currentDir.toAbsolutePath()}`"

def workDirname = System.console().readLine 'Working directory> '
Path workDir = Paths.get(workDirname).toAbsolutePath()
def workDirFile = workDir.toFile()
if (workDirFile.exists() || workDirFile.mkdirs()) {
    if (workDirFile.canWrite()) {
        System.setProperty('user.dir', workDirname)
    } else {
        System.err.println "The working directory `${workDirname}` is not writeable."
        System.exit 2
    }
} else {
    System.err.println "The working directory `${workDirname}` is invalid."
    System.exit 1
}

def outputDir = Paths.get(System.properties['user.dir'] as String).toAbsolutePath()
println "Working directory: `${outputDir}`"
def outputDirFile = outputDir.toFile()

File outputFile = [outputDirFile, 'PathsDemo.txt']
outputFile << 'PathsDemo test'
println "Written to `${outputFile}`"

def outputFilename = System.console().readLine 'Output filename> '
outputFile = [outputDirFile, outputFilename]
if (!(outputFile.parentFile.exists() || outputFile.parentFile.mkdirs())) {
    System.err.println "The output directory `${outputFile.parentFile}` is invalid."
    System.exit 3
}
outputFile << 'PathsDemo test'
println "Written to ${outputFile}"
