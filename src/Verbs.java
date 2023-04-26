import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public interface Verbs {
    String RED = "\033[0;31m";//set your text to red color
    String RED_BOLD = "\033[1;31m";
    String YELLOW = "\u001b[33;1m";
    String GREEN = "\u001B[32m";
    String reset = "\u001B[0m"; //set back your text to OG color
    int chartSize = 6;

    Scanner keyboardInput = new Scanner(System.in);

    String[] fillCompAnswer(int choice);

    String[] getUserAnswer();

    String[] getCompAnswer();

    //consistently get the stem from the generated verb
    String parseStem(String verb, int choice);

    //generate the correct chart for your user answer to be compared with
    default String[] makeCorrectChart(String verb, String[] endings, int choice) {
        String[] answer = new String[6];

        for(int i = 0; i < chartSize; ++i) {
            answer[i] = parseStem(verb, choice) + endings[i];
        }

        return answer;
    }

    //generate the correct chart for verbs that need a helping verb
    default String[] makeCorrectChart(String[] helpingVerbs, String verb, int choice) {
        String[] answer = new String[chartSize];

        for(int i = 0; i < chartSize; ++i) {
            answer[i] = helpingVerbs[i] + " " + parseStem(verb, choice);
        }

        return answer;
    }

    //these will be for irregular past tense verbs
    default String[] makeCorrectChartIrregular (String[] helpingVerbs, String verb, int choice) {
        String[] answer = new String[chartSize];

        for(int i = 0; i < 6; ++i) {
            answer[i] = helpingVerbs[i] + " " + parseStem(verb, choice);
        }

        for(int i = 3; i < 6; ++i) {
            answer[i] += "s";
        }

        return answer;
    }

    //to get a random verb from your arraylist containing IR or ER verbs
    default String getRandomVerb(ArrayList<String> verbList) {
        Random indexGenerator = new Random();
        return verbList.get(indexGenerator.nextInt(verbList.size()));
    }

    //get the user's answer to store in an array
    default String[] collectUserAnswer() {
        String[] userAnswer = new String[chartSize];
        keyboardInput.nextLine();

        do {
            System.out.println("First person singular: ");
            userAnswer[0] = keyboardInput.nextLine();
        }
        while(isEmpty(userAnswer[0]));

        do {
            System.out.println("Second person singular: ");
            userAnswer[1] = keyboardInput.nextLine();
        }
        while(isEmpty(userAnswer[1]));

        do {
            System.out.println("Third person singular: ");
            userAnswer[2] = keyboardInput.nextLine();
        }
        while(isEmpty(userAnswer[2]));

        do {
            System.out.println("First person plural: ");
            userAnswer[3] = keyboardInput.nextLine();
        }
        while(isEmpty(userAnswer[3]));

        do {
            System.out.println("Second person plural: ");
            userAnswer[4] = keyboardInput.nextLine();
        }
        while(isEmpty(userAnswer[4]));

        do {
            System.out.println("Third person plural: ");
            userAnswer[5] = keyboardInput.nextLine();
        }
        while(isEmpty(userAnswer[5]));

        System.out.println();
        return userAnswer;
    }

    default boolean isEmpty(String input) {
        if(input.length() < 1) {
            System.out.println("Please enter something");
            return true;
        }
        return false;
    }


    //is the correct answer same as the students?
    default void declareResult(String[] compAnswer, String[] userAnswer) {
        for(int i = 0; i < chartSize; ++i) {
            if (!compAnswer[i].equals(userAnswer[i])) {
                System.out.println(RED + "INCORRECT!" + reset);
                System.out.println();
                return;
            }
        }
        System.out.println(GREEN + "CORRECT!" + reset);
        System.out.println();
    }



    //show the direction to remind user of their decision
    default void direction(Verbs obj, String verb) {
        if(obj.getClass().getName().indexOf('_') == -1) {
            System.out.println("Conjugate " + verb + " in the " + obj.getClass().getName());
            return;
        }
        int indexOf_ = obj.getClass().getName().indexOf('_');
        int length = obj.getClass().getName().length();
        System.out.print("Conjugate " + verb + " in the " + obj.getClass().getName().substring(0, indexOf_));
        System.out.println(" " + obj.getClass().getName().substring(indexOf_ + 1, length));

    }

    //this essentially prints a string's differences, apart from another compared string
   default void comparison(String input, String answer) {
        int inputLength = input.length();
        int ansLength = answer.length();

        String possibleEnding;

       if(inputLength > ansLength) {
           possibleEnding = input.substring(ansLength, inputLength);


           String beginning = input.substring(0, ansLength);

           for (int i = 0; i < beginning.length(); ++i) {
               if (input.charAt(i) != answer.charAt(i)) {
                   System.out.print(RED_BOLD + input.charAt(i) + reset);
               } else {
                   System.out.print(input.charAt(i));
               }
           }
           System.out.print(RED_BOLD + possibleEnding + reset);
       }

       else {
           for(int i = 0; i < input.length(); ++i) {
               if (input.charAt(i) != answer.charAt(i)) {
                   System.out.print(RED_BOLD + input.charAt(i) + reset);
               } else {
                   System.out.print(input.charAt(i));
               }
           }
           System.out.print(YELLOW + answer.substring(inputLength) + reset);
       }
    }

    //using the above method (printing string's differences), format the chart by providing an accurate amt of " "
    default void formatCharts(String a) {
        if (a.length() < 28) {
            int amtSpace = 28 - a.length();
            for(int i = 0; i < amtSpace; ++i) {
                System.out.print(" ");
            }
            System.out.print("|                    ");
        }
    }


    default void printHeader(int n) {
        System.out.printf("%-30s%-23s%-30s\n", "Singular", "|", "Plural");
        for(int i = 0; i < n; ++i) {
            System.out.print("—");
        }
        System.out.println();
    }
    default void compareCharts(String[] userAnswer, String[] compAnswer) {
        printHeader(65);
        for(int i = 0; i < chartSize / 2; ++i) {
            System.out.print((i + 1) + " ");
            comparison(userAnswer[i], compAnswer[i]);
            if(compAnswer[i].length() > userAnswer[i].length()) {formatCharts(compAnswer[i]);}
            else {formatCharts(userAnswer[i]);}
            comparison(userAnswer[i+3], compAnswer[i+3]);
            System.out.println();
        }
    }


    //format the charts neatly
    default void printEnhancedChart(String[] verbs) {
        System.out.println("" + GREEN);
        printHeader(65);
        for(int i = 0; i < chartSize / 2; ++i) {
            System.out.printf("%d %-28s%-21s%-30s", i + 1, verbs[i], "|", verbs[i+3]);
            System.out.println();
        }
        System.out.print("" + reset);
    }

    //fill up the verb list depending on user choice
    default ArrayList<String> getVerbList(int choice) throws FileNotFoundException {
        Scanner readVerbs;
        ArrayList<String> toReturn = new ArrayList<>();


        if (choice == 1) {
            File erVerb = new File("ERVerbs");
            readVerbs = new Scanner(erVerb);

        } else if (choice == 2) {
            File irVerb = new File("IRVerbs");
            readVerbs = new Scanner(irVerb);
        } else {
            File reVerb = new File("REVerbs");
            readVerbs = new Scanner(reVerb);
        }
        while (readVerbs.hasNextLine()) {
            String toAddVerb = readVerbs.nextLine();
            toReturn.add(toAddVerb);
        }


        readVerbs.close();
        return toReturn;



    }

    default void printUserAnswer(String[] userAnswer, String[] compAnswer) {
        System.out.println("Your Answer: ");
        compareCharts(userAnswer, compAnswer);
        System.out.println();
    }

    default void printCompAnswer(String[] compAnswer) {
        System.out.println("Correct Answer: ");
        printEnhancedChart(compAnswer);
        System.out.println();
    }

    //display choice of verb
    default int chooseErIrVerb() {
        int toReturn = 0;
        boolean needInput = true;
        System.out.println("Choose a type of verb (Enter in the number): ");
        System.out.println("1) ER Verb");
        System.out.println("2) IR Verb");
        System.out.println("3) RE Verb");

        while(needInput) {
            try {
                toReturn = keyboardInput.nextInt();
                if(toReturn < 1 || toReturn > 3) {
                    System.out.println("Please enter a number between 1 and 3.");
                }
                else {
                    needInput = false;
                }
            } catch (InputMismatchException E) {
                System.out.println("Please enter a number.");
                keyboardInput.next();
            }
        }

        /*while(toReturn < 1 || toReturn > 3) {
            System.out.println("Enter a number between 1 and 3.");
            toReturn = keyboardInput.nextInt();
        }*/

        return toReturn;
    }

    //remove additional spaces or capped letters to match up with comp
    default void modifyUserAnswer(String[] userAnswer) {
        for(int i = 0; i < userAnswer.length; ++i) {
            userAnswer[i] = userAnswer[i].trim();
            userAnswer[i] = userAnswer[i].toLowerCase();
        }
    }

}
