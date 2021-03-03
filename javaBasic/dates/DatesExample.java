package javaBasic.dates;

import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

public class DatesExample {
  public static void main(String[] args) {

    var now = new Date();
    
    var stringDate1 = DateFormat.getInstance().format(now);
    var stringDate2 = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(now);
    var stringDate3 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(now);
    
    System.out.println("DateFormat 1: " + stringDate1);
    System.out.println("DateFormat 2: " + stringDate2);
    System.out.println("DateFormat 3: " + stringDate3);

    var formatter1 = new SimpleDateFormat("dd.MM.yyy");
    var formatter2 = new SimpleDateFormat("dd/MM/yyy");
    var formatter3 = new SimpleDateFormat("dd|MM|yyy");

    var formatDate1 = formatter1.format(now);
    var formatDate2 = formatter2.format(now);
    var formatDate3 = formatter3.format(now);

    System.out.println("DateFormat 4: " + formatDate1);
    System.out.println("DateFormat 5: " + formatDate2);
    System.out.println("DateFormat 6: " + formatDate3);


    
    var time1 = LocalDate.now();
    var time2 = LocalTime.now();
    var time3 = LocalDateTime.now();
    
    // N metodos
    System.out.println("LocalDate -> " + time1.minusDays(10));
    System.out.println("LocalTime -> " + time2.plusHours(10));
    System.out.println("LocalDateTime -> " + time3.minusYears(10));

  }
}