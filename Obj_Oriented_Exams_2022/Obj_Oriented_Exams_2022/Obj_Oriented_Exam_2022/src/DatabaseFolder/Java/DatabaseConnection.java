package DatabaseFolder.Java;

import java.sql.*;

public class DatabaseConnection {

    public void mainConnection() throws SQLException {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb", "root", "DAN1945mor");
            Statement stmt = con.createStatement();


        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
