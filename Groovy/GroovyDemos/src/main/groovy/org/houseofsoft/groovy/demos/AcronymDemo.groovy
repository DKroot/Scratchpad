#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode

@CompileStatic(TypeCheckingMode.SKIP)
static String snakeCaseToAcronym(String s) {
  (s ? s.split(/_/)*.getAt(0).join() : '')
}

def printAcronymFor(String s) {
  println "Acronym for `${s}` = `${snakeCaseToAcronym(s)}`"
}

printAcronymFor 'nlm_idconverter'
printAcronymFor 'word'
printAcronymFor ''