package ai.ecma.io.homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 * Created by: Mehrojbek
 * DateTime: 20/09/24 19:19
 **/
public class FolderCopy {

    public static void main(String[] args) {

        try {
            Path source = Path.of("files");
            Path target = Path.of("files1/");

            //homework.txt files1/homework.txt

            if (!Files.exists(target)) {
                Files.createDirectory(target);
            }

            List<Path> sourcePathList = Files.walk(source).toList();

            for (Path path : sourcePathList) {

                //files1 -> files1/homework.txt
                Path tempTarget = target.resolve(path.getFileName());

                //file papka emas
                if (Files.isRegularFile(path)) {

                    Files.copy(path, tempTarget, StandardCopyOption.REPLACE_EXISTING);

                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
