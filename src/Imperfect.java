import java.io.FileNotFoundException;


public class Imperfect extends UniversalVerbs implements Verbs {

    public Imperfect() throws FileNotFoundException {
        super();
    }


    public String[] fillCompAnswer(int choice) {
        String[] endings = {"ais", "ais", "ait", "ions", "iez", "aient"};
        return makeCorrectChart(generatedVerb, endings, choice);
    }

    public String parseStem(String verb, int choice) {
        String baseStem = verb.substring(0, verb.length() - 2);
        if(verb.contains("prendre")) {
            return verb.substring(0, verb.length() - 3);
        }
        else if(verb.contains("duire")) {
            return baseStem + "s";
        }
        else if(choice == 2) {
            return baseStem + "iss";
        }
        return baseStem;
    }

}
