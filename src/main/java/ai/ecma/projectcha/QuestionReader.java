package ai.ecma.projectcha;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by: Mehrojbek
 * DateTime: 27/09/24 21:34
 **/
public class QuestionReader {


    public static void main(String[] args) {

        try (InputStream inputStream = new FileInputStream("dtm/questions2.txt")) {

            byte[] bytes = inputStream.readAllBytes();
            String text = new String(bytes);

            String[] strings = text.split("----------------------------------------");


            //1875. (MEDIUM) savol-1875 Haftada necha kun bor.
            //Keyingi qator ham bor edi.
            //Va yana bitta qator bor
            //Javoblar:
            //7-kun
            //6-kun
            //5-kun
            //4-kun

            List<Question> questions = new ArrayList<>();

            for (String questionFullText : strings) {

                questionFullText = clearFirstNumbers(questionFullText);
                if (questionFullText.trim().isEmpty()) {
                    continue;
                }

                int fromIndex = questionFullText.indexOf("(");
                int endIndex = questionFullText.indexOf(")");

                if (endIndex == -1) {
                    System.out.println("Topolmadim");
                }

                String levelStr = questionFullText.substring(fromIndex + 1, endIndex);

                QuestionLevelEnum levelEnum = QuestionLevelEnum.valueOf(levelStr);

                questionFullText = questionFullText.replace("(", "").replace(")", "").replace(levelStr, "").trim();

                int questionEndIndex = questionFullText.indexOf("Javoblar:");

                String questionText = questionFullText.substring(0, questionEndIndex);

                questionFullText = questionFullText.replace("Javoblar:", "").replace(questionText, "").trim();

                String[] optionStrings = questionFullText.split("\n");

                List<Option> options = new ArrayList<>();
                for (int i = 0; i < optionStrings.length; i++) {
                    Option option = new Option(
                            optionStrings[i],
                            i == 0
                    );
                    options.add(option);
                }

                Question question = new Question(
                        questionText,
                        levelEnum,
                        options
                );

                questions.add(question);


            }

            for (Question question : questions) {
                System.out.println("----------");
                System.out.println(question);
                System.out.println("----------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static String clearFirstNumbers(String questionFullText) {
        Pattern pattern = Pattern.compile("\\d+\\.");
        Matcher matcher = pattern.matcher(questionFullText);
        if (matcher.find()) {
            String group = matcher.group();
            return questionFullText.replace(group, "");
        }
        return questionFullText;
    }

}
