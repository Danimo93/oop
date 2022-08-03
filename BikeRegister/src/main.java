import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        RegisterProgram reg = new RegisterProgram();
        Database data = new Database();

        reg.menu();
    }
}
