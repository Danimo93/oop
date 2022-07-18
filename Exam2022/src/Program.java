import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {

    //Here is the main menu, this is the part of the program that calls on other methods based on user input.
    public void menu() throws SQLException {
        System.out.println("Welcome to the Quiz \nWhat do you want to do?");
        menuOptions();
        boolean check = false; //This check variable is kinda useless, but without it, I don't get the switch to work right so, it stays.
        Scanner scan = new Scanner(System.in);

        while (!check){

            String input = scan.next();

            switch (input){

                case "0":
                    newUser();// this crashes if you try and add the same username twice, why tho? name is not a primary key for score, nor is it unique
                    menuOptions();
                    break;

                case "1":
                    scoreForOne();
                    menuOptions();
                    break;

                case "2":
                    top3History();
                    System.out.println("----------------------");
                    menuOptions();
                    break;

                case "3":
                    top3Boxing();
                    System.out.println("----------------------");
                    menuOptions();
                    break;

                case "4":
                    Database d = new Database();
                    d.getAllPoints();
                    menuOptions();
                    break;

                case "5":
                    System.out.println("Goodbye and welcome again");
                    System.exit(1);

                default:
                    System.out.println("Not a valid option, try again\n");
                    menuOptions();

            }

        }
    }

    //It is easier to have the Options that the user can select be in its own method, this way we can just call the method when we need it, it also looks fancy
    public void menuOptions(){
        List<String> menuOptions = Arrays.asList(
                "Play the game",
                "Show the score card of one play",
                "Show the best scores for History Quiz",
                "Show the best scores for Boxing Quiz",
                "List all users and there scores and topics",
                "Exit the game");
        int i = 0;
        for (String x : menuOptions) {
            System.out.println(i + ". " + x);
            i = i + 1;
        }
    }


    //This method creates a new user and adds it to the database, it then gives the user a choice about what quiz they want to play
    public void newUser() throws SQLException {
        System.out.println("Please enter you new username");

        Database d = new Database();

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String name = input;

        System.out.println("What quiz do you want to play?\n1 for a Multi Choice History quiz or 2 for a binary Boxing quiz");

        input = scan.nextLine();

        int choice = Integer.parseInt(input);

        if (choice == 1){
            //Call quize 1
            User u = new User(name, 0, "History");
            d.newDbUser(u);
            historyQuestions(u);
        }else if (choice == 2){
            //Call quize 2
            User u = new User(name, 0, "Boxing");
            d.newDbUser(u);
            boxingQuestions(u);
        }else {
            System.out.println("That is not a valid choice");

        }

    }


    public void scoreForOne() throws SQLException {
        System.out.println("What is the username for the player");

        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();

        Database d = new Database();

        d.scoreForOneDb(name);
    }

    //I don't know why I made these two bellow, just kinda feels right... My brain... it is frying...
    public void top3History() throws SQLException {
        Database d = new Database();
        d.selectTop3History();
    }

    public void top3Boxing() throws SQLException {
        Database d = new Database();
        d.selectTop3Boxing();
    }


    /*
    * The methods boxingQuestions() and historyQuestions() are responsible for giving the user the questions, keeping score
    * and returning that score to the database method updatePoints() when the round is over.
    * */
    public void boxingQuestions(User u) throws SQLException {
        Database_Questions dataQ = new Database_Questions();
        BinaryQuiz BinQ = new BinaryQuiz(); //hmmmm... how do I use this.. how do I use this.....
        Scanner scan = new Scanner(System.in);
        //BinQ.showQuestion();
        ArrayList<BinaryQuiz> qArray = dataQ.BQ();
        int points = 0;

        int i = 0;
        for (BinaryQuiz ignored : qArray) {
            System.out.println("Here is the question");
            System.out.println(qArray.get(i).getQuestion());
            if (scan.nextLine().toLowerCase().equals(qArray.get(i).getCorrectAnswer())){
                System.out.println("That is correct");
                points += 1;
                System.out.println("Current points " + points);
            }else {
                System.out.println("That is wrong");
                System.out.println("Current points " + points);
            }
            i += 1;
        }
        System.out.println("Round over \n" + "You received a total of: " + points + " points\n");
        Database d = new Database();

        d.updatePoints(points, u);
    }

    public void historyQuestions(User u) throws SQLException {
        Database_Questions dataQ = new Database_Questions();
        Scanner scan = new Scanner(System.in);
        ArrayList<MultichoiceQuiz> historyArray = dataQ.MQ();
        int points = 0;
        int i = 0;

        for (MultichoiceQuiz ignored: historyArray) {
            System.out.println("Here is the question");
            System.out.println(historyArray.get(i).getQuestion());
            System.out.println(historyArray.get(i).getAnswerA()  + ". " + " " + historyArray.get(i).getAnswerB()
                    + ". " + " "
                    + historyArray.get(i).getAnswerC()  + ". " + " " + historyArray.get(i).getAnswerD() + ". ");
            if (scan.nextLine().toLowerCase().equals(historyArray.get(i).getCorrectAnswer())){
                System.out.println("That is correct");
                points += 1;
                System.out.println("Current points " + points);
            }else {
                System.out.println("That is wrong");
                System.out.println("Current points " + points);
            }
            i += 1;
        }
        System.out.println("Round over \n" + "You received a total of: " + points + " points\n");
        Database d = new Database();

        d.updatePoints(points, u);
    }



}


