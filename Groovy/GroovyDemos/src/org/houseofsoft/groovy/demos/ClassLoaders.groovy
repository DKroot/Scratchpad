#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

class Helper {
  static void printClassLoadersAndClasspath(ClassLoader classLoader) {
    if (!classLoader) {
      return
    }
    if (classLoader.parent) {
      printClassLoadersAndClasspath(classLoader.parent)
    }
    println "## Loading via ${classLoader} ##"
    if (classLoader instanceof URLClassLoader) {
      println "Looking in the following locations:"
      classLoader.URLs.each {
        println "${(it.protocol == 'file' ? it.path : it)}"
      }
    }
  }
}

void method() {
  println "class=`${getClass()}`"
  println "classLoader=`${getClass().classLoader}`"
  Helper.printClassLoadersAndClasspath getClass().classLoader
}

class Foo {
  static void staticMethod() {
    println "class=`${Foo.class}`"
    println "classLoader==`${Foo.class.classLoader}`"
    Helper.printClassLoadersAndClasspath Foo.class.classLoader
  }
}

println '\n## Instance context ##\n'
method()

println '\n## Static context ##\n'
Foo.staticMethod()
