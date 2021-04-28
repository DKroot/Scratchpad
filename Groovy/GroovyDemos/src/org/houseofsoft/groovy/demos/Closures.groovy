#!/usr/bin/env groovy
package org.houseofsoft.groovy.demos

@GrabConfig(systemClassLoader = true) @Grab('net.sourceforge.jtds:jtds:1.3.1')
@Grab('p6spy:p6spy:3.9.1')

import groovy.sql.Sql

import java.sql.ResultSet

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

String server = 'citbasitassql2a.nih.gov'
String dbName = 'ITASDEV2'
String osUser = env['USERNAME'] ?: env['USER']
String dbUser = env['SPRING_DATASOURCE_USERNAME']
assert dbUser : 'SPRING_DATASOURCE_USERNAME env. var. is required'
String dbPassword = env['SPRING_DATASOURCE_PASSWORD']
assert dbPassword : 'SPRING_DATASOURCE_PASSWORD env. var. is required'
final String SQL_SERVER_JDBC_DRIVER = 'com.p6spy.engine.spy.P6SpyDriver'

Sql.withInstance("jdbc:p6spy:jtds:sqlserver://${server}/${dbName};maxStatements=0;appName=ITASINT;wsid=T-${osUser}",
    dbUser as String, dbPassword, SQL_SERVER_JDBC_DRIVER) { db ->
  println 'Connected to MS SQL DB'

  def i = 0

  use ItasRepository, {
    db.simple(indvSsnId, pp) {
      //noinspection GroovyAssignabilityCheck
      println it
    }

    db.getWrkHrs(indvSsnId, pp) { ResultSet rs ->
      while (rs.next()) {
        def record = rs.toRowResult()
        println "#${++i} ${record}"
      }
    }
  }
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
