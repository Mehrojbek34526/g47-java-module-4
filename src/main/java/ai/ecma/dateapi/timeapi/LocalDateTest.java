package ai.ecma.dateapi.timeapi;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;

/**
 * Created by: Mehrojbek
 * DateTime: 16/09/24 21:04
 **/
public class LocalDateTest {

    public static void main(String[] args) {

//        LocalDate localDate = LocalDate.of(2024, Month.SEPTEMBER, 16);
        LocalDate localDate = LocalDate.now();
        localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

        LocalDate localDate1 = localDate.plusMonths(2);

        System.out.println("localDate1 = " + localDate1);

        System.out.println("localDate.isLeapYear() = " + localDate.isLeapYear());

        IsoChronology chronology = localDate.getChronology();
        System.out.println("Chronology = " + chronology);

//        LocalDate.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("localDate = " + localDate);

    }

}
