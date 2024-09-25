package ai.ecma.dateapi.legacy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by: Mehrojbek
 * DateTime: 16/09/24 20:00
 **/
public class CalendarTest {


    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
//        Calendar calendar = new GregorianCalendar();

//        calendar.add(ChronoUnit.DAYS.ordinal(),5);
//        calendar.add(Calendar.DATE, 5);
//        calendar.add(Calendar.DATE, 16);
//        calendar.roll(Calendar.DATE, 16);

//        Scanner scanner = new Scanner(System.in);
//        int dayOfMonth = scanner.nextInt();

        calendar.setLenient(false);

//        calendar.set(Calendar.DATE, dayOfMonth);

        //**-**-1998
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("'R' dd/MM/yyyy HH:mm:ss.SSS 'This is day of the year->' D");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

//        System.out.println("simpleDateFormat.format(calendar.getTime()) = " + simpleDateFormat.format(new Date()));


        Scanner scanner = new Scanner(System.in);
        System.out.print("Sanani kiriti: ");
        String dateStr = scanner.nextLine();

        try {
            Date parsed = simpleDateFormat.parse(dateStr);
            System.out.println("parsed = " + parsed);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


//        System.out.println("calendar = " + calendar.getTime());

    }

}
