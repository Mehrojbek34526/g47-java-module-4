package ai.ecma.io.homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by: Mehrojbek
 * DateTime: 20/09/24 19:35
 **/
public class FileSize {

    public static void main(String[] args) throws IOException {

//        Path path = Path.of("files1");
//        long length = path.toFile().length();
//        System.out.println("length = " + length);

        Path path = Path.of("files");
        List<Path> paths = Files.walk(path).toList();

        for (Path onePath : paths) {

            if (Files.isRegularFile(onePath)) {

                String[] split = onePath.getFileName().toString().split("\\.");
                String extension = split[split.length - 1];//mp3,jpeg,png,...

                long mb = (onePath.toFile().length() / 1024) / 1024;

                if (extension.equals("mp3") && mb > 120) {

                }

            }

        }

    }

}
