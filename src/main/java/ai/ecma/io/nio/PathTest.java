package ai.ecma.io.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 * Created by: Mehrojbek
 * DateTime: 18/09/24 21:12
 **/
public class PathTest {

    public static void main(String[] args) throws IOException {

//        Path path = Path.of("data/2024");
//        System.out.println("path.getFileName() = " + path.getFileName());
//        System.out.println("path.getParent() = " + path.getParent());
//        Path normalize = path.normalize();
//        System.out.println("nor = " + normalize);

//        Path resolve = path.resolve(Path.of("NOVEMBER"));
//        System.out.println("resolve = " + resolve);

//        Files.createDirectories(resolve);

        Path source = Path.of("files/Test.txt");
        Path target = Path.of("data/2024/SEPTEMBER/18/Test1.txt");

//        Files.copy(source, target, StandardCopyOption.COPY_ATTRIBUTES);

//        Files.writeString(source,"Yangi Ma'lumot yozyapman", StandardOpenOption.APPEND);
//        String str = Files.readString(source);
//        System.out.println(str);
//
//        List<String> strings = Files.readAllLines(source);
//        strings.forEach(System.out::println);

        List<Path> walk = Files.walk(Path.of("/Users/mehrojbekmavlonov/IdeaProjects/lessons/g47-java-module-4")).toList();

        Scanner scanner = new Scanner(System.in);
        String searchedFileName = scanner.nextLine();

        for (Path path : walk) {

            //text.txt
            if (Files.isRegularFile(path)) {

                if (path.getFileName().toString().equals(searchedFileName))
                    System.out.println("Toptim -> data -> " + Files.readString(path));

            } else if (Files.isDirectory(path)) {

            }

        }
//        Paths.get()

    }

}
