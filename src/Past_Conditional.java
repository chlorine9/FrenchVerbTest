import java.io.FileNotFoundException;

public class Past_Conditional extends Past_Tense {
    public Past_Conditional() throws FileNotFoundException {
        super();
    }
    public String[] fillCompAnswer(int choice) {
        if(findIrregular(exceptionVerbList, generatedVerb)) {
            String[] condEtrePrefix = {"serais", "seras", "serait", "serions", "seriez", "seraient"};
            return makeCorrectChart(condEtrePrefix, generatedVerb, choice);
        }
        String[] condAvoirPrefix = {"aurais", "aurais", "aurait", "aurions", "auriez", "auraient"};
        return makeCorrectChart(condAvoirPrefix, generatedVerb, choice);
    }

}
