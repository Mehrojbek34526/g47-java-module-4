package ai.ecma.dateapi.timeapi;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by: Mehrojbek
 * DateTime: 16/09/24 21:37
 **/
public class DurationTest {

    public static void main(String[] args) {

//        Duration duration = Duration.of(18, ChronoUnit.DAYS);
//        Duration duration = Duration.of(450, ChronoUnit.HOURS);
        Duration duration = Duration.of(45089, ChronoUnit.SECONDS);
//        System.out.println("duration = " + duration);

        LocalTime from = LocalTime.now();
        LocalTime to = LocalTime.of(23,56);

        Duration between = Duration.between(from, to);
        System.out.println("between = " + between);

        System.out.println("between.toSeconds() = " + between.toSeconds());

    }

}
