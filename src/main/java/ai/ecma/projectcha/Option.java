package ai.ecma.projectcha;

/**
 * Created by: Mehrojbek
 * DateTime: 27/09/24 19:31
 **/

public class Option {

    private String text;

    private boolean correct;

    public Option(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "Option{" +
                "text='" + text + '\'' +
                ", correct=" + correct +
                '}';
    }
}
