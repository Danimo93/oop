import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {

        Program p = new Program();
        Database d = new Database();
        Database_Questions dq = new Database_Questions();
        BinaryQuiz b = new BinaryQuiz();

        p.menu(); //This is the main program, after creating the database, editing the root password and running the two methods below this should be run
        // to get the program to run, it starts the menu that gives the user options on what to do.


        //Run these two fill the database with Questions
        //dq.historyQuestions();
        //dq.boxingQuestions();


        //Under here are many of the methods that I call upon to test them before I add them to the 'main' program
        //This way I can test each method in a vacuum before adding it to other methods, and see that they work like they should.

        //p.menuOptions();
        //p.newUser();
        //d.printArray();
        //p.login();
        //p.scoreForOne();
        //d.selectTop3History();
        //d.selectTop3Boxing();
        //dq.printArray();
        //b.showQuestion();
        //p.boxingQuestions();
        //dq.printArray();
        //p.historyQuestions();
        //d.getAllPoints();

    }
}
