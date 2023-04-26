import java.io.FileNotFoundException;

public class Subjunctive extends UniversalVerbs implements Verbs{


    public Subjunctive() throws FileNotFoundException {
        super();
    }

    public String[] fillCompAnswer(int choice) {
        if(generatedVerb.contains("prendre")) {
            String[] prendreEndings = {"ne", "nes", "ne", "ions", "iez", "nent"};
            return makeCorrectChart(generatedVerb, prendreEndings, choice);
        }
        else if(choice == 2) {
            String[] irEndings = {"sse", "sses", "sse", "ssions", "ssiez", "ssent" };
            return makeCorrectChart(generatedVerb, irEndings, choice);
        }
        else {
            String[] erReEndings = {"e" , "es", "e", "ions", "iez", "ent"};
            return makeCorrectChart(generatedVerb, erReEndings, choice);
        }

    }

    @Override
    public String parseStem(String verb, int choice) {
        if(verb.contains("prendre")) {
            return verb.substring(0, verb.length() - 3);
        }
        else if(verb.contains("duire")) {
            return verb.substring(0, verb.length() - 3) + "s";
        }
        else if (choice == 1 || choice == 3) {
            return verb.substring(0, verb.length() - 2);
        }
        return verb.substring(0, verb.length() - 1);
    }
}
