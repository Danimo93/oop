package QuizTerminal;

import java.sql.*;
import java.util.Scanner;

public abstract class Questions extends User{

    private int score;

    //This method collects data from the DB and prints out the questions. It also gives you points for correct answer
    public void multiChoiceQuiz(User user) throws ClassNotFoundException, SQLException {
        setTopic("Nature");

        //JDBC Driver name
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb",
                "root", "DAN1945mor");

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM quizdb.multichoicequiz");

        Scanner userInput = new Scanner(System.in);


        //While loop for the questions collected from the database
        while(rs.next()){
            System.out.println(rs.getString("question"));
            System.out.println("1: " + rs.getString("answerA"));
            System.out.println("2: " + rs.getString("answerB"));
            System.out.println("3: " + rs.getString("answerC"));
            System.out.println("4: " + rs.getString("answerD"));

            String playerChoice = userInput.nextLine();
            playerChoice = playerChoice.toLowerCase();

            //A codeblock which gives you points for correct answer and souts if you gets the wrong answer
            if(playerChoice.equals(rs.getString("correctAnswer"))){
                System.out.println("You got the correct answer! One point for you :)");
                score++;
                System.out.println("You have " + score + " points!\n");

            }else if(playerChoice != rs.getString("correctAnswer")){
                System.out.println("You got the wrong answer, no points for you...");
            }
        }
        new Scoreboard().addScore(user, score, getTopic());
    }

    //This method collects data from the DB as well and prints out the questions which was stored.
    public void binaryQuiz(User user) throws ClassNotFoundException, SQLException {

        setTopic("Food");

        //Same JDBC Driver name
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb",
                "root", "DAN1945mor");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM quizdb.binaryquiz");

        Scanner userInput = new Scanner(System.in);



        //While loop for the questions collected from the database
        while(rs.next()){
            System.out.println(rs.getString("question"));

            String playerChoice = userInput.nextLine();
            playerChoice = playerChoice.toLowerCase();

            if(playerChoice.equals(rs.getString("correctAnswer"))){
                System.out.println("You got the correct answer! One point for you :)");
                score++;
                System.out.println("You have " + score + " points!\n");
            }else if(playerChoice != rs.getString("correctAnswer")){
                System.out.println("You got the wrong answer, no points for you...");
            }
        }
        new Scoreboard().addScore(user, score, getTopic());
    }

    //GETTERS AND SETTERS

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
