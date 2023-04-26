import java.io.FileNotFoundException;
public class Past_Tense extends UniversalVerbs implements Verbs {

    public Past_Tense() throws FileNotFoundException {
        super();
    }


    public String[] fillCompAnswer(int choice) {
       if(findIrregular(exceptionVerbList, generatedVerb)) {
           String[] etrePrefix = {"suis", "es", "est", "sommes", "êtes", "sont"};
           return makeCorrectChartIrregular(etrePrefix, generatedVerb, choice);

       }
        String[] avoirPrefix = {"ai", "as", "a", "avons", "avez", "ont"};
        return makeCorrectChart(avoirPrefix, generatedVerb, choice);
    }

    @Override
    public String parseStem(String verb, int choice) {
        if(verb.contains("prendre")) {
            return generatedVerb.substring(0, generatedVerb.indexOf("endre")) + "is";
        }
        else if(verb.contains("mettre")) {
            return generatedVerb.substring(0, generatedVerb.indexOf("ettre")) + "is";
        }
        else if(verb.contains("duire")) {
            return generatedVerb.substring(0, generatedVerb.indexOf("re")) + "t";
        }
        else if (choice == 1) {
            return generatedVerb.substring(0, generatedVerb.length() - 2) + "é";
        }
        else if(choice == 2) {
            return generatedVerb.substring(0, generatedVerb.length() - 1);
        }
        return generatedVerb.substring(0, generatedVerb.length() - 2) + "u";
    }
    protected boolean findIrregular(String[] sample, String target) {
        for(String compare : sample) {
            if(compare.equals(target)) {
                return true;
            }
        }
        return false;
    }


}
