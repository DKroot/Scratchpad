package org.houseofsoft;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeDemo {

  public static void main(String[] args) {
    // create a calendar
    var cal = Calendar.getInstance();

    // print current time zone
    System.out.printf("Timestamp: %tc in the current time zone: %s%n", cal,
        cal.getTimeZone().getDisplayName());

    // set the time zone with the given time zone value and print it
    cal.setTimeZone(TimeZone.getTimeZone("GMT"));
    System.out
        .printf("Timestamp: %tc in the time zone: %s%n", cal, cal.getTimeZone().getDisplayName());

    // set the time zone with the given time zone value and print it
    cal.setTimeZone(TimeZone.getTimeZone("America/New_York"));
    System.out
        .printf("Timestamp: %tc in the time zone: %s%n", cal, cal.getTimeZone().getDisplayName());

    var dateTime = LocalDateTime.now();
    var utilDate = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    System.out.printf("Timestamp: %tc", utilDate);
  }
}