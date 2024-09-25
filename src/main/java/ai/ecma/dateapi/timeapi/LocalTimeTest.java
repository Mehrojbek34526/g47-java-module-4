package ai.ecma.dateapi.timeapi;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * Created by: Mehrojbek
 * DateTime: 16/09/24 21:13
 **/
public class LocalTimeTest {

    public static void main(String[] args) {

//        LocalTime localTime = LocalTime.of(21, 44);
//        LocalTime localTime = LocalTime.now(ZoneId.of("Asia/Tokyo"));
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = localTime.plusMinutes(28);
        System.out.println("localTime1 = " + localTime1);

//        int i = localTime.get(ChronoField.SECOND_OF_MINUTE);
        int i = localTime.get(ChronoField.NANO_OF_SECOND);
        System.out.println("i = " + i);
        System.out.println("localTime = " + localTime);

//        ZoneId.getAvailableZoneIds().forEach(s -> System.out.println(s));

    }

}
