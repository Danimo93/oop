import java.sql.*;
import java.util.ArrayList;

public class Database_Registering {

    public Database_Registering(){
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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb?useSSL=false", "root", "DAN1945mor");
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
            String question1 = "INSERT INTO RegisterBikes(BrandName) VALUES (?)";
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

    //The two methods bellow have the job of making an array filled with BinaryQuiz objects that can be used with other methods


    //The two methods bellow have the job of making an array filled with MultichoiceQuiz objects that can be used with other methods
    public ArrayList<BikeRegistering> RG() throws SQLException{
        ArrayList<BikeRegistering> RegArray = new ArrayList<>();
        Connection con = conDb();
        Statement state = con.createStatement();
        String getBikeRegistering = "SELECT * FROM BikeRegistering";

        ResultSet resSet = state.executeQuery(getBikeRegistering);

        while (resSet.next()){
            RegArray.add(inputBikes(resSet));
        }
        return RegArray;
    }

    public BikeRegistering inputBikes(ResultSet r) throws SQLException{
        BikeRegistering reg = new BikeRegistering();

        reg.setComponentA(r.getString("question"));
        reg.setComponentB(r.getString("answerA"));
        reg.setComponentC(r.getString("answerB"));
        //reg.setCorrectAnswer(r.getString("correctAnswer"));

        return reg;
    }


}

