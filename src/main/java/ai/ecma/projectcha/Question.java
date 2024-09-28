package ai.ecma.projectcha;

import java.util.List;

/**
 * Created by: Mehrojbek
 * DateTime: 27/09/24 19:30
 **/
public class Question {
    private String text;

    private QuestionLevelEnum level;

    //variantlar a,b,c,d
    private List<Option> options;

    public Question(String text, QuestionLevelEnum level, List<Option> options) {
        this.text = text;
        this.level = level;
        this.options = options;
    }

    @Override
    public String toString() {
        return "Question{" +
                "text='" + text + '\'' +
                ", level=" + level +
                ", options=" + options +
                '}';
    }
}
