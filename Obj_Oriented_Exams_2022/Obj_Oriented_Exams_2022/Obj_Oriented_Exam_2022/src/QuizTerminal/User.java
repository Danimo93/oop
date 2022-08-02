package QuizTerminal;

import DatabaseFolder.Java.AddUserToDB;
import DatabaseFolder.Java.DatabaseConnection;

import java.util.Scanner;

public class User extends DatabaseConnection {

    //VARIABLES
    int userID;
    String userName;
    String userInput; //Variable for scanner and userInput
    int userScore = 0;
    String topic;

    //Empty Constructor
    public User(){

    }

    //CONSTRUCTOR FOR userName
    public User(String userName){
        this.userName = userName;
    }

    //This prints at the start of the Terminal when you enter your name before it is added to the scoreboard

    public User addUserOrg (){
        Scanner Scan = new Scanner(System.in);

        System.out.println("Enter your name:");
        userInput = Scan.nextLine();
        String userName = userInput;

        User u = new User(userName);

        return u;
    }

    //GETTER AND SETTERS
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserInput() {
        return userInput;
    }
    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public int getUserScore() {
        return userScore;
    }
    public void setUserScore(int userScore) {
        this.userScore = userScore;
    }

    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
}
