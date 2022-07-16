import java.sql.SQLException;

public class Main{
    public static void main(String[] args) throws SQLException {
        Database data = new Database();
        Database_Register RegDB = new Database_Register();
        Parkinglot park = new Parkinglot();
        Cars car = new Cars();
        RegisterCar reg = new RegisterCar();

        //Price pc = new Price ();

        park.manu();


    }
}

