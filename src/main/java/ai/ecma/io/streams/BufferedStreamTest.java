package ai.ecma.io.streams;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * Created by: Mehrojbek
 * DateTime: 18/09/24 21:05
 **/
public class BufferedStreamTest {

    public static void main(String[] args) {

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("files/Test.txt"))) {

            byte[] bytes = in.readAllBytes();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
