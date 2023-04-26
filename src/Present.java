import java.io.FileNotFoundException;


public class Present extends UniversalVerbs implements Verbs {


    public Present() throws FileNotFoundException {
        super();
    }

    //get the stem
    public String parseStem(String verb, int choice) {
        if(verb.contains("prendre") || verb.contains("mettre") || verb.contains("duire")) {
            return verb.substring(0, verb.length() - 3);
        }
        return verb.substring(0, verb.length() - 2);
    }

    //set up the correct chart
    public String[] fillCompAnswer(int choice) {
        if(choice == 1) {
            String[] erEndings = {"e", "es", "e", "ons", "ez", "ent"};
            return makeCorrectChart(generatedVerb, erEndings, choice);
        }
        else if(choice == 2) {
            String[] irEndings = {"is", "is", "it", "issons", "issez", "issent"};
            return makeCorrectChart(generatedVerb, irEndings, choice);
        }
        else if (generatedVerb.contains("prendre")){
            String[] prendreEndings = {"ds", "ds", "d", "ons", "ez", "nent"};
            return makeCorrectChart(generatedVerb, prendreEndings, choice);
        }
        else if (generatedVerb.contains("mettre") || generatedVerb.contains("battre")) {
            String[] mettreEndings = {"s", "s", "", "tons", "tez", "tent"};
            return makeCorrectChart(generatedVerb, mettreEndings, choice);
        }
        else if(generatedVerb.contains("duire")) {
            String[] uireEndings = {"s", "s", "t", "sons", "sez", "sent"};
            return makeCorrectChart(generatedVerb, uireEndings, choice);
        }
        else {
            String[] reEndings = {"s", "s", "", "ons", "ez", "ent"};
            return makeCorrectChart(generatedVerb, reEndings, choice);
        }

    }


}
