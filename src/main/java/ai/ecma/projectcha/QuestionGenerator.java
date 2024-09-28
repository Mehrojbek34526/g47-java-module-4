package ai.ecma.projectcha;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by: Mehrojbek
 * DateTime: 27/09/24 20:42
 **/
public class QuestionGenerator {

    public static void main(String[] args) {

        try {
            OutputStream outputStream = new FileOutputStream("dtm/questions2.txt");

            StringBuilder questions = new StringBuilder();
            QuestionLevelEnum[] values = QuestionLevelEnum.values();
            int counter = 0;
            for (QuestionLevelEnum value : values) {
                for (int i = 1; i <= 1_000; i++) {
                    counter++;
                    questions.append(counter).append(".")
                            .append(" (").append(value.name()).append(") ")
                            .append("savol-").append(counter)
                            .append(" Haftada necha kun bor.\nKeyingi qator ham bor edi.\nVa yana bitta qator bor\n")
                            .append("Javoblar:\n")
                            .append("7-kun\n")
                            .append("6-kun\n")
                            .append("5-kun\n")
                            .append("4-kun\n")
                            .append("----------------------------------------\n");
                }
            }

            outputStream.write(questions.toString().getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
