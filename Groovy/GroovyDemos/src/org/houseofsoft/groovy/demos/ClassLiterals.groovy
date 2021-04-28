package org.houseofsoft.groovy.demos

printClass String.class
// Possible in Groovy, not Java
printClass String

Integer i = 5
printClass i.getClass()

static void printClass(Class c) {
  println c
}

