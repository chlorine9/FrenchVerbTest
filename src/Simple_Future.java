import java.io.FileNotFoundException;

public class Simple_Future extends Conditional_Present implements Verbs{

    public Simple_Future() throws FileNotFoundException {
        super();
    }

    @Override
    public String[] fillCompAnswer(int choice) {
        String[] endings = {"ai", "as", "a", "ons", "ez", "ont"};
        return makeCorrectChart(generatedVerb, endings, choice);
    }

}
