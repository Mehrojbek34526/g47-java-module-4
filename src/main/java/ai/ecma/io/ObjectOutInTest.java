package ai.ecma.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Mehrojbek
 * DateTime: 18/09/24 21:49
 **/
public class ObjectOutInTest {

    static List<Student> students = new ArrayList<>(List.of(
//            new Student("VAlijon",21),
//            new Student("Alijon",28),
//            new Student("Salimjon",19)
    ));


    public static void main(String[] args) {

        Path path = Path.of("files/db.txt");

        read(path);

//        write(path);

    }

    private static void read(Path path) {

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path.toFile()))) {

            List<Student> students = (List<Student>) in.readObject();
            students.forEach(System.out::println);

        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void write(Path path) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path.toFile()))) {

            outputStream.writeObject(students);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static class Student implements Serializable {
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
