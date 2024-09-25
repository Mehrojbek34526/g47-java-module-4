package ai.ecma.regex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by: Mehrojbek
 * DateTime: 20/09/24 20:51
 **/
public class RegexTest {

    public static void main(String[] args) {

        System.out.print("Textni kiriting: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        String replace = text.replace("w", "v");
//        System.out.println("replace = " + replace);

        String replaceAll = text.replaceAll("\\d{2}", "(digit)");
//        System.out.println("replaceAll = " + replaceAll);

        String[] split = text.split("\\.");
        System.out.println("Arrays.toString(split) = " + Arrays.toString(split));



        Pattern pattern = Pattern.compile("\\d{3}");

        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("match-> " + matcher.group() + " start: " + start + " end: " + end);
        }
        //[3-8]

//      1. Bir xonali sonlarni nechatligi va hammasini consolega print
//      2. Ikki xonali sonlar nechatligi va hammasini consolega print
//      3. Uch xonali sonlar 3 dan 8 gacha raqamlar qatnashgan sonlar nechtaligi va hammasini consolega print
//      4. Kichkina harfda yozilgan uzunligi 3 dan 7 gacha bo’lgan so’zlarni hammasini consolega print.
//      5. Faqat katta harf bilan yozilgan uzunligi 4 dan 7 gacha bo’lgan so’zlarni consolga chiqarish
//      6. “free” dan boshlanadigan so’zlarni ekranga chiqarish
//      7. “stu” bilan tugagan so’zlarni ekranga chiqarish

    }

}
