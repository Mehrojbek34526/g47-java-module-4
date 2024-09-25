package ai.ecma.dateapi.timeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/**
 * Created by: Mehrojbek
 * DateTime: 16/09/24 21:22
 **/
public class LocalDateTimeTest {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
//        LocalDateTime newLocal = localDateTime.plusDays(15);
//        LocalDateTime newNewlocal = newLocal.plusHours(29);
        System.out.println("localDateTime = " + localDateTime);

        LocalDate localDate = LocalDate.now();
//        LocalTime time = LocalTime.MAX;
        LocalTime time = LocalTime.MIN;

//        LocalDateTime localDateTime1 = LocalDateTime.of(localDate, time);
        LocalDateTime localDateTime1 = LocalDateTime.of(2024,9,16,21,28);
//        System.out.println("localDateTime1 = " + localDateTime1);



    }

}
