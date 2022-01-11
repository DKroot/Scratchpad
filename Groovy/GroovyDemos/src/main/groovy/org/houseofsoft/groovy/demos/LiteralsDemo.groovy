#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode
import org.houseofsoft.groovy.demos.helpers.AppOptions

printClass String.class
// Possible in Groovy, not Java
printClass String

Integer i = 5
printClass i.getClass()

void printClass(Class c) {
  println c
}

demoImplicitConstructors()

// Dynamic compilation is required: either of the `AppOptions` instance class or this method
@CompileStatic(TypeCheckingMode.SKIP) // required for implicit constructors
def demoImplicitConstructors() {
  AppOptions appOptions = []
  appOptions = [iniFilePath: 'foo.ini']
  appOptions = [iniFilePath: 'foo.ini', helpRequested: true]

  println appOptions
}

