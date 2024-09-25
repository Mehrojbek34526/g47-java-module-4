package ai.ecma.io.readwrite;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by: Mehrojbek
 * DateTime: 18/09/24 20:48
 **/
public class ReaderTest {

    public static void main(String[] args) {

        read();
//        write();

    }

    private static void write() {

        try (FileWriter writer = new FileWriter("files/Test.txt")) {

            writer.write("\nYangi text qo'shildi");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void read() {
        try (FileReader reader = new FileReader("files/Test.txt");) {

            String encoding = reader.getEncoding();
            System.out.println(encoding);
            while (reader.ready()){
                System.out.print((char) reader.read());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
