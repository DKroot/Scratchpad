#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

class Helper {
  /**
   * Prints a class loading hierarchy (parents on top) and classpath for any `URLClassLoader`-s
   *
   * @param classLoader e.g. `getClass().classLoader` from an instance context or `Foo.class` from a static context.
   * Defaults to the context ClassLoader for this thread, which is typically set to the application class loader.
   * @return number of levels in the class loader hierarchy
   */
  static int printClassLoadersAndClasspath(ClassLoader classLoader = Thread.currentThread().contextClassLoader) {
    def level = 1
    if (classLoader) {
      if (classLoader.parent) {
        level = printClassLoadersAndClasspath(classLoader.parent) + 1
      }
      def heading = '#' * level
      println "${heading} Loading via ${classLoader} ${heading}"
      if (classLoader instanceof URLClassLoader) {
        println 'Looking in the following locations:'
        classLoader.URLs.each {
          println "${(it.protocol == 'file' ? it.path : it)}"
        }
      }
    }
    level
  }
}

void method() {
  println "class=`${getClass()}`"
  println "Class Loader `${getClass().classLoader}`"
  Helper.printClassLoadersAndClasspath getClass().classLoader

  println "\nThread classLoader=`${Thread.currentThread().contextClassLoader}`"
  Helper.printClassLoadersAndClasspath()
}

static void staticMethod() {
  println "class=`${ClassLoaders.class}`"
  println "Class Loader `${ClassLoaders.class.classLoader}`"
  Helper.printClassLoadersAndClasspath ClassLoaders.class.classLoader

  println "\nThread classLoader=`${Thread.currentThread().contextClassLoader}`"
  Helper.printClassLoadersAndClasspath()
}

println '\n== Instance context ==\n'
method()

println '\n== Static context ==\n'
staticMethod()