import java.io.FileNotFoundException;

public class Future_Perfect extends Past_Tense{
    public Future_Perfect() throws FileNotFoundException {
        super();
    }
    public String[] fillCompAnswer(int choice) {
        if(findIrregular(exceptionVerbList, generatedVerb)) {
            String[] futEtrePrefix = {"serai", "seras", "sera", "serons", "serez", "seront"};
            return makeCorrectChart(futEtrePrefix, generatedVerb, choice);
        }
        String[] futAvoirPrefix = {"aurai", "auras", "aura", "aurons", "aurez", "auront"};
        return makeCorrectChart(futAvoirPrefix, generatedVerb, choice);
    }
}
