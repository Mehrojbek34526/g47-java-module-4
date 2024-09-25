package ai.ecma.io.streams;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;

/**
 * Created by: Mehrojbek
 * DateTime: 18/09/24 19:23
 **/
public class InputStreamOutputExample {

    public static void main(String[] args) {

//        fileRead();
//        fileWrite();
        fileTest();

    }

    private static void fileTest() {

//        File file = new File("files1");
//
//        System.out.println("file.exists() = " + file.exists());
//
//        if (!file.exists()){
//            file.mkdir();
//        }

//        File file = new File("files1");

        LocalDate localDate = LocalDate.now().plusDays(2);
        int year = localDate.getYear();
        Month month = localDate.getMonth();
        int day = localDate.getDayOfMonth();

        File file = new File("data/" + year + "/" + month.name() + "/" + day);

//        if (!file.exists()) {
//            file.mkdirs();
//        }

        System.out.println("file.delete() = " + file.delete());

//        String parent = file.getParent();
//        System.out.println(parent);
//        System.out.println("file.getParentFile().getParent() = " + file.getParentFile().getParent());
//        String absolutePath = file.getAbsolutePath();
//        System.out.println("absolutePath = " + absolutePath);

//        System.out.println(file);

//        //data/2024/SEPTEMBER/18/homework1.txt
//        try (OutputStream outputStream = new FileOutputStream(file + "Homework.txt")) {
//            byte[] bytes = """
//                     public class Homework {
//                     public static void main(String[] args) {
//                            System.out.println("Test");
//                        }
//                        }
//                    """
//                    .getBytes();
//            outputStream.write(bytes);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //2024/september/18/homework1.txt
        //2024/september/18/homework2.txt
        //2024/september/19/homework2.txt

    }

    private static void fileWrite() {
        //        String pathname = "/Users/mehrojbekmavlonov/Downloads/Test.txt";
        String pathname = "files/Test.txt";
//        File file = new File(pathname);
//        System.out.println(file);
//        File file = new File("files/Test.txt");

        try (OutputStream outputStream = new FileOutputStream(pathname)) {

            String str = "\nHello World";
            byte[] bytes = str.getBytes();
            outputStream.write(bytes);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void fileRead() {
        //        String pathname = "/Users/mehrojbekmavlonov/Downloads/Test.txt";
        String pathname = "files/Test.txt";
//        File file = new File(pathname);
//        System.out.println(file);
//        File file = new File("files/Test.txt");

        try (InputStream inputStream = new FileInputStream(pathname)) {

            byte[] bytes = inputStream.readAllBytes();

            String str = new String(bytes);

            System.out.println(str);

//            int read = inputStream.read();
//
//            char symbol = (char) read;
//
//            System.out.println(symbol);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
