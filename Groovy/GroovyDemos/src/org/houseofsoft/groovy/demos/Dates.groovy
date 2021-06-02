package org.houseofsoft.groovy.demos

import java.sql.Timestamp
import java.time.LocalDateTime

def nowLocalDateTime = LocalDateTime.now()
println "Local time: ${nowLocalDateTime}"
println "Formatted: ${nowLocalDateTime.format('MM/dd/yy HH:mm')}"
println "Day of a week: ${nowLocalDateTime.dayOfWeek} (#${nowLocalDateTime.dayOfWeek.value})"

def nowDateTime = new Date()
println "Time: ${nowDateTime}"
println "Formatted: ${nowDateTime.toLocalDateTime().format('MM/dd/yy HH:mm')}"

Timestamp nowTimestamp = nowDateTime.toTimestamp()
println "Timestamp: ${nowTimestamp}"
println "Formatted: ${nowTimestamp.toLocalDateTime().format('MM/dd/yy HH:mm')}"
