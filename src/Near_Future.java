import java.io.FileNotFoundException;

public class Near_Future extends UniversalVerbs implements Verbs{

    public Near_Future () throws FileNotFoundException {
        super();
    }


    public String[] fillCompAnswer(int choice) {
        String[] venirPrefix = {"vais", "vas", "va", "allons", "allez", "vont"};
        return makeCorrectChart(venirPrefix, generatedVerb, choice);
    }
}
