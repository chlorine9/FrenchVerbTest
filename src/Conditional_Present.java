import java.io.FileNotFoundException;
public class Conditional_Present extends Imperfect implements Verbs {
    public Conditional_Present() throws FileNotFoundException {
        super();
    }

    @Override
    public String parseStem(String verb, int choice) {
        if(choice == 1 || choice == 2) {
            return generatedVerb;
        }
        else {
            return generatedVerb.substring(0, generatedVerb.length() - 1);
        }
    }
}
