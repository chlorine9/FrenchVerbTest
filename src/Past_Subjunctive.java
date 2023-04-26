import java.io.FileNotFoundException;

public class Past_Subjunctive extends Past_Tense {
    public Past_Subjunctive() throws FileNotFoundException {
        super();
    }

    public String[] fillCompAnswer(int choice) {
        if(findIrregular(exceptionVerbList, generatedVerb)) {
            String[] subjEtrePrefix = {"sois", "sois", "soit", "soyons", "soyez", "soient"};
            return makeCorrectChart(subjEtrePrefix, generatedVerb, choice);
        }
        String[] impavoirPrefix = {"aie", "aies", "ait", "ayons", "ayez", "aient"};
        return makeCorrectChart(impavoirPrefix, generatedVerb, choice);
    }

}
