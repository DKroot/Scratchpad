#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

import groovy.sql.Sql

void method1(Closure closure) {
  println 'method(Closure)'
  closure(42)
}

void method2(Sql self, Closure closure) {
  println 'method2(Sql, Closure)'
  closure(self)
}

@SuppressWarnings('unused') // intentionally
void method3(Sql self, String indvSsnId, Closure closure) {
  println 'method3(Sql, String, Closure)'
  closure(indvSsnId)
}

println 'Calling the methods with closures'
method1() { Object it ->
  println it
}

method1 { Object it ->
  println it
}

method2(null) { Sql it ->
  println it
}

method2 null, { Sql it ->
  println it
}

String indvSsnId = '100033707'

method3(null, indvSsnId) { String it ->
  println it
}

method3 null, indvSsnId, { String it ->
  println it
}