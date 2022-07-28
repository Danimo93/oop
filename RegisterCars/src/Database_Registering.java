import java.sql.*;
import java.util.ArrayList;

public class Database_Registering {
    public Database_Questions(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException ex){
            System.out.println("Driver error");
            ex.printStackTrace();
        }
    }
    //NB! dont forget to add your root password to the DriverManager :D
    public Connection conDb(){
        Connection con = null; // I don't know why, but if I don't do this, it won't work, strange.
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb?useSSL=false", "root", "Your Password");
        }
        catch (SQLException ex) {
            System.out.println("Oh no! Something went wrong when connecting to the database");
            ex.printStackTrace();
        }
        return con;
    }

    //This method adds the Histories questions to the database
    //Before the exam a fellow student showed me that you can have multiple statements in one method, very hand, especially for this.
    public void historyQuestions() {
        try {

            Connection con = conDb();

            //Question 1
            String question1 = "INSERT INTO multichoicequiz(question, answerA, answerB, answerC, answerD, correctAnswer) VALUES (?,?,?,?,?,?)";
            PreparedStatement stat1 = con.prepareStatement(question1);
            stat1.setString(1, "In 793 the Vikings raided Lindisfarne, but where is that?");
            stat1.setString(2, "A - Scotland");
            stat1.setString(3, "B - Northen England");
            stat1.setString(4, "C - Southern England");
            stat1.setString(5, "D - Ireland");
            stat1.setString(6, "b");

            //Question 2
            String question2 = "INSERT INTO multichoicequiz(question, answerA, answerB, answerC, answerD, correctAnswer) VALUES (?,?,?,?,?,?)";
            PreparedStatement stat2 = con.prepareStatement(question2);
            stat2.setString(1, "Who was the first emperor of rome");
            stat2.setString(2, "A - Julius Caesar");
            stat2.setString(3, "B - Nero");
            stat2.setString(4, "C - Caesar Augustus");
            stat2.setString(5, "D - Hadrian");
            stat2.setString(6, "c");

            //Question 3
            String question3 = "INSERT INTO multichoicequiz(question, answerA, answerB, answerC, answerD, correctAnswer) VALUES (?,?,?,?,?,?)";
            PreparedStatement stat3 = con.prepareStatement(question3);
            stat3.setString(1, "What was Genghis Khan known for");
            stat3.setString(2, "A - A grate Chinese poet");
            stat3.setString(3, "B - Indian mathematician that invented 0");
            stat3.setString(4, "C - Tibetan Munch");
            stat3.setString(5, "D - Founder of the Mongol Empire");
            stat3.setString(6, "d");

            //Question 4
            String question4 = "INSERT INTO multichoicequiz(question, answerA, answerB, answerC, answerD, correctAnswer) VALUES (?,?,?,?,?,?)";
            PreparedStatement stat4 = con.prepareStatement(question4);
            stat4.setString(1, "Who was given the title of Norway's eternal king?");
            stat4.setString(2, "A - Olav the Holy");
            stat4.setString(3, "B - Harald V");
            stat4.setString(4, "C - Olav V");
            stat4.setString(5, "D - Harald Fairhair");
            stat4.setString(6, "a");


            stat1.executeUpdate();
            stat2.executeUpdate();
            stat3.executeUpdate();
            stat4.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println("Uff.. can't add these to the database");
            ex.printStackTrace();
        }

    }


    //I guessed that the binary Questions should have a yes or no answer, I assume, that's how I interpret it, on or off.
    //If I did misinterpret, I hope I didn't misinterpret too badly.
    public void boxingQuestions() {
        try {

            Connection con = conDb();

            //Question 1
            String question1 = "INSERT INTO binaryquiz(question, correctAnswer) VALUES (?,?)";
            PreparedStatement stat1 = con.prepareStatement(question1);
            stat1.setString(1, "Has Tyson Fury has won an Olympic medal? y or n");
            stat1.setString(2, "n");

            //Question 2
            String question2 = "INSERT INTO binaryquiz(question, correctAnswer) VALUES (?,?)";
            PreparedStatement stat2 = con.prepareStatement(question2);
            stat2.setString(1, "Is it true that Mike Tyson has 44 pro wins by KO? y or n");
            stat2.setString(2, "y");

            //Question 3
            String question3 = "INSERT INTO binaryquiz(question, correctAnswer) VALUES (?,?)";
            PreparedStatement stat3 = con.prepareStatement(question3);
            stat3.setString(1, "Is a flyweight heavier then feather weight? y or n");
            stat3.setString(2, "n");

            //Question 4
            String question4 = "INSERT INTO binaryquiz(question, correctAnswer) VALUES (?,?)";
            PreparedStatement stat4 = con.prepareStatement(question4);
            stat4.setString(1, "Was George Foreman 45 years old when he became heavyweight champion y or n");
            stat4.setString(2, "y");

            stat1.executeUpdate();
            stat2.executeUpdate();
            stat3.executeUpdate();
            stat4.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println("Oh now, can't add these to the database");
            ex.printStackTrace();
        }
    }

    //The two methods bellow have the job of making an array filled with BinaryQuiz objects that can be used with other methods
    public ArrayList<BinaryQuiz> BQ() throws SQLException {
        ArrayList<BinaryQuiz> binQuiz = new ArrayList<>();
        Connection con = conDb();
        Statement state = con.createStatement();
        String getBinQuestions = "SELECT * FROM binaryquiz";

        ResultSet resSet = state.executeQuery(getBinQuestions);

        while (resSet.next()){
            binQuiz.add(boxingMap(resSet));
        }
        return  binQuiz;
    }

    public BinaryQuiz boxingMap(ResultSet r) throws SQLException {
        BinaryQuiz b = new BinaryQuiz();

        b.setQuestion(r.getString("question"));
        b.setCorrectAnswer(r.getString("correctAnswer"));

        return b;
    }


    //The two methods bellow have the job of making an array filled with MultichoiceQuiz objects that can be used with other methods
    public ArrayList<MultichoiceQuiz> MQ() throws SQLException{
        ArrayList<MultichoiceQuiz> multiArray = new ArrayList<>();
        Connection con = conDb();
        Statement state = con.createStatement();
        String getMulitQuestions = "SELECT * FROM multichoicequiz";

        ResultSet resSet = state.executeQuery(getMulitQuestions);

        while (resSet.next()){
            multiArray.add(historieMap(resSet));
        }
        return multiArray;
    }

    public MultichoiceQuiz historieMap(ResultSet r) throws SQLException{
        MultichoiceQuiz m = new MultichoiceQuiz();

        m.setQuestion(r.getString("question"));
        m.setAnswerA(r.getString("answerA"));
        m.setAnswerB(r.getString("answerB"));
        m.setAnswerC(r.getString("answerC"));
        m.setAnswerD(r.getString("answerD"));
        m.setCorrectAnswer(r.getString("correctAnswer"));

        return m;
    }
}
