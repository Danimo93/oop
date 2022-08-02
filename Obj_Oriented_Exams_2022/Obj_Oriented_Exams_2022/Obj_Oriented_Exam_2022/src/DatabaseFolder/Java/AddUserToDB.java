package DatabaseFolder.Java;

import QuizTerminal.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddUserToDB extends User{

    //This pulls the data from the DB which controls the username, score and topic of the game
    public void registerUser(User u) {

        try {
            String input = "INSERT INTO quizdb.scorehistory(userName, userScore, topic) VALUES (?, ?, ?)";

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb", "root", "DAN1945mor");
            PreparedStatement prepstmt = con.prepareStatement(input);
            prepstmt.setString(1, u.getUserName());
            prepstmt.setInt(2, u.getUserScore());
            prepstmt.setString(3, u.getTopic());

            prepstmt.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
