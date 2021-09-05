#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode
import org.houseofsoft.groovy.demos.helpers.SystemHelper

void method() {
  println "class=`${getClass()}`"
  println "Class Loader `${getClass().classLoader}`"
  SystemHelper.printClassLoadersAndClasspath getClass().classLoader

  println "\nThread classLoader=`${Thread.currentThread().contextClassLoader}`"
  SystemHelper.printClassLoadersAndClasspath()
}

@CompileStatic(TypeCheckingMode.SKIP) // calling instance method `Script#println` from static context
static void staticMethod() {
  println "class=`${ClassLoadersDemo.class}`"
  println "Class Loader `${ClassLoadersDemo.class.classLoader}`"
  SystemHelper.printClassLoadersAndClasspath ClassLoadersDemo.class.classLoader

  println "\nThread classLoader=`${Thread.currentThread().contextClassLoader}`"
  SystemHelper.printClassLoadersAndClasspath()
}

println '\n== Instance context ==\n'
method()

println '\n== Static context ==\n'
staticMethod()