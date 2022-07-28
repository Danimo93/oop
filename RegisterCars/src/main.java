import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        Register reg = new Register();
        Database data = new Database();

        reg.menu();
    }
}
