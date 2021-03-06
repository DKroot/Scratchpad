#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

println 'DemoExtensions'

use (StringExtensions) {
  println "Foo Bar".left(3)
  println "Foo Bar".leftBefore(' ')

  use (TransmissionFileExtensions) {
    println 42.formatForTransmission(5)
    println 42.1d.formatForTransmission(5, 2)

    println 10.75001d.formatHours(4)
    println 40.25001d.formatHours(9)
  }
}