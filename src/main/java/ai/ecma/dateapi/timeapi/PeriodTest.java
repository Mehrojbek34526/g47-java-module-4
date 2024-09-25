package ai.ecma.dateapi.timeapi;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

/**
 * Created by: Mehrojbek
 * DateTime: 16/09/24 21:41
 **/
public class PeriodTest {

    public static void main(String[] args) {


        //

        LocalDate from = LocalDate.of(1997, Month.MAY, 4);
        LocalDate to = LocalDate.now();

        Period period = Period.between(from, to);
        System.out.println("between = " + period);

        System.out.println("period.toTotalMonths() = " + period.toTotalMonths());

//        System.out.println("period.getDays() = " + period.getDays());


    }

}
