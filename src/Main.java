import java.io.FileNotFoundException;
import java.util.InputMismatchException;


public class Main {
    public static void main(String[] args) {
        char userContinue = 'y';
        while(userContinue == 'y') {
            try {
                int choice = displayTenseOrMood();
                Verbs test = redirect(choice);

                test.declareResult(test.getUserAnswer(), test.getCompAnswer());
                test.printCompAnswer(test.getCompAnswer());
                test.printUserAnswer(test.getUserAnswer(), test.getCompAnswer());

                userContinue = continueFunction();

            }
            catch (InputMismatchException e) {
                System.out.println("\u001B[31m" + "PROGRAM TERMINATED. PLEASE ENTER IN A NUMBER FOR DIRECTIONS." );
                userContinue = 'n';
                Verbs.keyboardInput.close();
            }
            catch (FileNotFoundException e2) {
                System.out.println("File not found; resolve.");
                userContinue = 'n';
                Verbs.keyboardInput.close();
            }
        }
        Verbs.keyboardInput.close();
    }


    //display choices available to user
    public static int displayTenseOrMood() {
        boolean needInput = true;
        int toReturn = 0;

        System.out.println("Choose a tense/mood (Enter in the number): ");
        System.out.println("1) Present");
        System.out.println("2) Imperfect");
        System.out.println("3) Simple Future");
        System.out.println("4) Past Tense");
        System.out.println("5) Present Conditional");
        System.out.println("6) Subjunctive");
        System.out.println("7) Pluperfect");
        System.out.println("8) Near Future");
        System.out.println("9) Recent Past");
        System.out.println("10) Future Perfect");
        System.out.println("11) Past Conditional");
        System.out.println("12) Past Subjunctive");

        while(needInput) {
            try {
                toReturn = Verbs.keyboardInput.nextInt();
                if(toReturn < 1 || toReturn > 12) {
                    System.out.println("Please enter a number between 1 and 12.");
                }
                else {
                    needInput = false;
                }
            } catch (InputMismatchException E) {
                System.out.println("Please enter a number.");
                Verbs.keyboardInput.nextLine();
            }
        }
        return toReturn;
    }

    //determine if the user would like to repeat the exercise
    public static char continueFunction() {
        System.out.println("Would you like more practice? Press 'y' for yes, 'n' for no.");
        String toReturn = Verbs.keyboardInput.next();
        return toReturn.charAt(0);
    }

    //instantiate the correct type of verb based on user specification
    public static Verbs redirect(int choice) throws FileNotFoundException {
        if(choice < 1 || choice > 12) {
            System.out.println("Please enter a number between 1 and 12.");
            choice = Verbs.keyboardInput.nextInt();
            return redirect(choice);
        }

        switch(choice) {
            case 1:
                return new Present();
            case 2:
                return new Imperfect();
            case 3:
                return new Simple_Future();
            case 4:
                return new Past_Tense();
            case 5:
                return new Conditional_Present();
            case 6:
                return new Subjunctive();
            case 7:
                return new Pluperfect();
            case 8:
                return new Near_Future();
            case 9:
                return new Recent_Past();
            case 10:
                return new Future_Perfect();
            case 11:
                return new Past_Conditional();
            default:
                return new Past_Subjunctive();
        }

    }


}
