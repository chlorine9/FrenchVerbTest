import java.io.FileNotFoundException;
import java.util.ArrayList;

public abstract class UniversalVerbs implements Verbs{
    protected final String[] exceptionVerbList = {"rester", "visiter", "tomber", "monter",
            "arriver", "descendre"};
    private String[] userAnswer;
    private String[] compAnswer;

    private ArrayList<String> verbList;
    protected String generatedVerb;

    protected int choice;

    public UniversalVerbs() throws FileNotFoundException {
        choice = chooseErIrVerb();
        verbList = getVerbList(choice);
        generatedVerb = getRandomVerb(verbList);

        compAnswer = fillCompAnswer(this.choice);
        direction(this, generatedVerb);


        userAnswer = collectUserAnswer();
        modifyUserAnswer(userAnswer);
    }

    public String parseStem(String verb, int choice) {
        return verb;
    }

    public String[] getUserAnswer() {
        return userAnswer;
    }

    public String[] getCompAnswer() {
        return compAnswer;
    }
}
