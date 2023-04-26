import java.io.FileNotFoundException;

public class Pluperfect extends Past_Tense implements Verbs {

    public Pluperfect() throws FileNotFoundException {
        super();
    }

    @Override
    public String[] fillCompAnswer(int choice) {
        if(findIrregular(exceptionVerbList, generatedVerb)) {
            String[] impetrePrefix = {"étais", "étais", "était", "étions", "étiez", "étaient"};
            return makeCorrectChart(impetrePrefix, generatedVerb, choice);
        }
        String[] impavoirPrefix = {"avais", "avais", "avait", "avions", "aviez", "avaient"};
        return makeCorrectChart(impavoirPrefix, generatedVerb, choice);
    }


}
