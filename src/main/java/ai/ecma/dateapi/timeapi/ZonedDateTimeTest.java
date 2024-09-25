package ai.ecma.dateapi.timeapi;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by: Mehrojbek
 * DateTime: 16/09/24 21:30
 **/
public class ZonedDateTimeTest {

    public static void main(String[] args) {

//        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
//        ZonedDateTime now = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
        ZonedDateTime now = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Kolkata"));
        System.out.println("now = " + now);

    }

}
