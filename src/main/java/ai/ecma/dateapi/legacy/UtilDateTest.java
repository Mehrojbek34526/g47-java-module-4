package ai.ecma.dateapi.legacy;

import java.util.Date;

/**
 * Created by: Mehrojbek
 * DateTime: 16/09/24 19:51
 **/
public class UtilDateTest {

    public static void main(String[] args) {

//        Date date = new Date(System.currentTimeMillis() + 5 * 60 * 1000);
//        date1.setTime(System.currentTimeMillis() + 10 * 60 * 1000);
//        System.out.println("date = " + date1);

        Date date1 = new Date(System.currentTimeMillis());

        Date date2 = new Date(System.currentTimeMillis() + 5 * 60 * 1000);

        if (date2.after(date1)) {
            System.out.println("Keyin");
        } else {
            System.out.println("Oldin");
        }

        //1970 1-yanvar 00:00
        System.out.println("date = " + date1);
//        System.out.println("millis = " + date.getTime());


    }

}
