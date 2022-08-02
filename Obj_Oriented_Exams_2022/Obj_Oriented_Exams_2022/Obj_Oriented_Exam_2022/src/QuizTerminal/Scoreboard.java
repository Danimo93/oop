package QuizTerminal;

import java.sql.*;

public class Scoreboard {

    String userName;
    int userScore;
    String topic;

    //This method prints the whole scoreboard
    public void printScoreboard() throws SQLException, ClassNotFoundException {

        try {
            //JDBC Driver name
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb", "root", "DAN1945mor");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM quizdb.scorehistory");

            //If the text is unclear this prints "Scoreboard" in the Quiz Game Terminal
            System.out.println("""
                       _____                    _                         _
                      / ____|                  | |                       | |
                     | (___   ___ ___  _ __ ___| |__   ___   __ _ _ __ __| |
                      \\___ \\ / __/ _ \\| '__/ _ \\ '_ \\ / _ \\ / _` | '__/ _` |
                      ____) | (_| (_) | | |  __/ |_) | (_) | (_| | | | (_| |
                     |_____/ \\___\\___/|_|  \\___|_.__/ \\___/ \\__,_|_|  \\__,_|
                    
                    If the Scoreboard is empty, get your game on! One user, one chance!
                    """);

            //This while prints the name, score and topic of the quiz
            while (rs.next()) {

                System.out.println("|ID: " + rs.getInt(1)
                        + " |Name: " + rs.getString(2)
                        + " |Score: " + rs.getInt(3)
                        + " |Topic: " + rs.getString(4));
            }

            //The catch prints if there is something wrongs with the code
        }catch (Exception e){
            System.out.println(e);
            System.out.println("""
                                                
                        Oops something went wrong...
                                                
                        Try to restart the game!
                                                
                        """);
        }
    }

    //This method adds first and foremost score, but also username and topic back to the database
    public void addScore(User user, int score, String topic) throws SQLException {

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb", "root", "DAN1945mor");
            String statement = "INSERT INTO quizdb.scorehistory (user, score, topic) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(statement);

            stmt.setString(1, user.getUserName());
            stmt.setInt(2, score);
            stmt.setString(3, topic);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //GETTERS AND SETTERS
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
}
