package ai.ecma.dateapi.timeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * Created by: Mehrojbek
 * DateTime: 16/09/24 21:32
 **/
public class TimeApiFortmatterTest {

    public static void main(String[] args) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy'T'HH:mm:ss");

        String format = dateTimeFormatter.format(LocalDateTime.now());
//        System.out.println("format = " + format);

        TemporalAccessor parse = dateTimeFormatter.parse("30.09.2024T21:34:08");
        System.out.println("parse = " + parse);

        LocalDateTime from = LocalDateTime.from(parse);
//        System.out.println("parse = " + parse + " from = " + from);

        LocalDate date = from.toLocalDate();
        LocalTime localTime = from.toLocalTime();


    }

}
