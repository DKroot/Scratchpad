#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

import groovy.transform.CompileStatic
import groovy.transform.TypeCheckingMode

import org.houseofsoft.groovy.demos.helpers.StringExtensions
import org.houseofsoft.groovy.demos.helpers.TaFileExtensions

class Main {
  @CompileStatic(TypeCheckingMode.SKIP) // required to use extension method(s)
  static void demo() {
    StringExtensions.left("Foo Bar", 3)

    use(StringExtensions) {
      println "Foo Bar".left(3)
      println "Foo Bar".leftBefore(' ')
    }

    use(TaFileExtensions) {
      println 42.formatForTransmission(5)
      println 42.1d.formatForTransmission(5, 2)

      println 10.75001d.formatHours(4)
      println 40.25001d.formatHours(9)
    }
  }
}

Main.demo()