package ai.ecma.io.streams;

import java.io.*;

/**
 * Created by: Mehrojbek
 * DateTime: 18/09/24 20:17
 **/
public class DataInputOutputStreamExample {

    public static void main(String[] args) {

//        write();
//        read();

    }

    private static void read() {

        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("files/datastream.txt"))) {

            long num = dataInputStream.readLong();
            System.out.println("num = " + num);

            boolean con = dataInputStream.readBoolean();
            System.out.println("con = " + con);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void write() {
        Long number = 1256L;
        boolean con = true;

//        File file = new File("files/datastream.txt");
//        if (!file.exists()) {
//            file.mkdir();
//        }

        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("files/datastream.txt"))) {

            dataOutputStream.writeLong(number);
            dataOutputStream.writeBoolean(con);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
