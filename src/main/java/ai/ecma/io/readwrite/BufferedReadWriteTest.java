package ai.ecma.io.readwrite;

import java.io.*;

/**
 * Created by: Mehrojbek
 * DateTime: 18/09/24 20:58
 **/
public class BufferedReadWriteTest {

    public static void main(String[] args) {

//        read();
//        write();

    }

    private static void write() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("files/Test2.txt"))) {

            for (int i = 0; i < 5; i++) {
                writer.write(i + " Yangi data");
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void read() {
        try (BufferedReader reader = new BufferedReader(new FileReader("files/Test.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
