#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

import groovy.sql.Sql

println 'Calling the methods with closures'
Map<String, String> env = System.env

method() { it ->
  println it
}
method { it ->
  println it
}

method2(null) { Sql it ->
  println it
}
method2 null, { Sql it ->
  println it
}

String indvSsnId = '100033707'
PayPeriod pp = [payYr: 2021, payPeriod: 1]

method3(null, indvSsnId) { String it ->
  println it
}
method3 null, indvSsnId, { String it ->
  println it
}

void method(Closure closure) {
  println 'method(Closure)'
  closure(42)
}

void method2(Sql self, Closure closure) {
  println 'method2(Sql, Closure)'
  closure(self)
}

void method3(Sql self, String indvSsnId, Closure closure) {
  println 'method3(Sql, String, Closure)'
  closure(indvSsnId)
}
