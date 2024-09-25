package ai.ecma.io.homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by: Mehrojbek
 * DateTime: 20/09/24 19:08
 **/
public class PrimeNumbers {

    public static void main(String[] args) {

        try {
            Path path = Path.of("numbers.txt");
            List<Path> pathList = Files.walk(path).toList();

            if (pathList.size() == 1) {

                Path findPath = pathList.get(0);

                String text = Files.readString(findPath);

                //[1,2,3] -> 1,2,3
                String[] numbers = text
                        .replace("[", "")
                        .replace("]", "")
                        .split(",");

                for (String number : numbers) {
                    number = number.trim();

                    int i = Integer.parseInt(number);



                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
