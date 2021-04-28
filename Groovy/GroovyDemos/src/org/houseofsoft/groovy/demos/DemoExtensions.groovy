package org.houseofsoft.groovy.demos

println 'DemoExtensions'

//use StringExtensions, {
  println "Foo Bar".left(3)
  println "Foo Bar".leftBefore(' ')

  use TransmissionFileExtensions, {
    println 42.formatForTransmission(5)
    println 42.1d.formatForTransmission(5, 2)
  }
//}