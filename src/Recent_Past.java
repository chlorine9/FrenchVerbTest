import java.io.FileNotFoundException;

public class Recent_Past extends UniversalVerbs implements Verbs {


    public Recent_Past() throws FileNotFoundException {
        super();

    }

    public String[] fillCompAnswer(int choice) {
        String[] venirPrefix = {"viens", "viens", "vient", "venons","venez", "viennent"};
        return makeCorrectChart(venirPrefix, generatedVerb, choice);
    }

    public String parseStem(String verb, int choice) {
       if(isVowel(verb.charAt(0))) {
           return "d'" + verb;
       }
       else {
           return "de " + verb;
       }
    }

    private boolean isVowel(char a) {
        switch(a) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'é':
            case 'è':
            case 'ê':
            case 'á':
            case 'à':
            case 'â':
                return true;
            default:
                return false;
        }
    }
}
