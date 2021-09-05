package org.houseofsoft.groovy.demos.helpers

class SystemHelper {
  /**
   * Prints a class loading hierarchy (parents on top) + classpath for any `URLClassLoader`-s
   *
   * @param classLoader e.g. `getClass().classLoader` or `Foo.class.classLoader` from a static context.
   * Defaults to the context class loader for this thread, which is typically set to the application class loader.
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

