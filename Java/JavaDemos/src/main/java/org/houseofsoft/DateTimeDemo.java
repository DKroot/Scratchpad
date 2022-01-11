package org.houseofsoft;

import java.io.File;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

public class DateTimeDemo {

  private static final DateTimeFormatter DATE_TIME_FILENAME_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss-SSS");

  public static void main(String[] args) throws URISyntaxException {
    var ldt = LocalDateTime.now();
    System.out.printf("LocalDateTime: %s in the system time zone%n", ldt);

    var d = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    System.out.printf("Converted to java.util.Date: %tc%n", d);

    //region java.util.Calendar
    var cal = Calendar.getInstance();

    // print current time zone
    System.out.printf("java.util.Calendar: %tc in the system time zone %s%n", cal,
        cal.getTimeZone().getDisplayName());

    // set the time zone with the given time zone value and print it
    cal.setTimeZone(TimeZone.getTimeZone("GMT"));
    System.out.printf("java.util.Calendar: %tc in the %s time zone%n", cal,
        cal.getTimeZone().getDisplayName());

    // set the time zone with the given time zone value and print it
    cal.setTimeZone(TimeZone.getTimeZone("America/New_York"));
    System.out.printf("java.util.Calendar: %tc in the %s time zone%n", cal,
        cal.getTimeZone().getDisplayName());
    //endregion

    //region Epoch time
    var classFileUrl = Objects.requireNonNull(DateTimeDemo.class.getClassLoader().getResource(
        String.format("%s.class", DateTimeDemo.class.getCanonicalName().replace('.', '/'))));
    var classFile = new File(classFileUrl.toURI());
    var modifiedTSEpochMilliseconds = classFile.lastModified();
    var modifiedTsLdt =
        Instant.ofEpochMilli(modifiedTSEpochMilliseconds).atZone(ZoneId.systemDefault())
            .toLocalDateTime();
    System.out.printf("Modification timestamp of %s: %s%n", classFile.getAbsolutePath(),
        modifiedTsLdt);
    System.out.printf("Formatted modification timestamp of %s%n",
        modifiedTsLdt.format(DATE_TIME_FILENAME_FORMATTER));
    //endregion
  }
}