package user.db;

import user.User;

import java.sql.*;
import java.util.ArrayList;

public class JDBCOps {
    public JDBCOps() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public ArrayList<User> readUsers() {
        ArrayList<User> result = new ArrayList<>();
        String readSql = "SELECT * FROM users";
        try {
            Connection con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/uniUsers?useSSL=false", "root", "DAN1945mor");

            Statement stmt = con.prepareStatement(readSql);
            ResultSet resultSet = stmt.executeQuery(readSql);

            while (resultSet.next()) {
                UserDTO userDTO = new UserDTO();
                userDTO.id = resultSet.getInt("id");
                userDTO.personnummer = resultSet.getString("personnummer");
                userDTO.name = resultSet.getString("name");


                User user = DTOConverter.parseUserDTO(userDTO);
                result.add(user);
            }

        }
        catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
        return result;
    }
}
