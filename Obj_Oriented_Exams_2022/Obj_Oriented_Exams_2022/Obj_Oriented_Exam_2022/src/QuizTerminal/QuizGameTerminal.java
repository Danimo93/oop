package QuizTerminal;

import java.util.Scanner;
import static java.lang.System.exit;

public class QuizGameTerminal extends Questions {
    //Questions extends User

    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        //This sout comes after the options array
        System.out.println("\nWow! So many options! What do you want to do?:");

    }

    //This terminal is the main terminal that displays when the program is first run.
    //Note that terminal() is only text
    public void terminal() {
        System.out.println("""
                -------------------------
                Welcome to the Quiz Arcade Game!
                -------------------------
                Remember to register your name under the user tab
                before selecting a quiz!
                
                This is an arcade game, if you wish to play more than once, pick a username people remembers!
                You never know when someone beats your score!
                """);

        //String array with all the options to the user as they run Main
        String[] options = {
                "1. Start the multiple choice quiz about Nature!",
                "2. Start the yes or no quiz about Food!",
                "3. Show the scoreboard!",
                "4. Exit Game"
        };

        //Classes added as objects
        Scoreboard sb = new Scoreboard();

        //Scanner for userInput
        Scanner userInput = new Scanner(System.in);

        //This codeblock takes all the userInputs and treats them in the scanner and displays what it is told to display
        int option = 1;
        User user = addUserOrg();
        while (option != 4) { //As long as the option is not the option that closes the program the menu will loop
            printMenu(options);
            try {
                option = userInput.nextInt();
                switch (option) {

                    //Case 1 prints out the multiple choice quiz
                    case 1 -> {
                        System.out.println("You have chosen the multiple choice quiz about Nature!");
                        multiChoiceQuiz(user);
                    }
                    //Case 2 prints out the binary quiz (The yes or no quiz)
                    case 2 -> {
                        System.out.println("You have chosen the yes or no quiz about Food!");
                        binaryQuiz(user);
                    }
                    //Case 3 prints out the scoreboard with all the players that have played
                    case 3 -> {
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        sb.printScoreboard();
                        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                        System.out.println("\n");
                    }
                    //Case 5 closes the game
                    case 4 -> {
                        System.out.println("Thanks for playing! You are now exiting the game, see you next time! ... ... ...");
                        exit(0);
                    }
                }

                //The catch prints if there is something wrongs with the code
            } catch (Exception e) {
                System.out.println("""
                                                
                        Oops something went wrong...
                                                
                        Try to restart the game!
                                                
                        """);
                userInput.next();
                }
            }
        }
    }
