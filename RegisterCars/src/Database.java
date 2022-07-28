import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    public Database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException ex){
            System.out.println("Error with the Driver");
            ex.printStackTrace();
        }
    }

    public Connection conDb(){
        Connection con = null; // I don't know why, but if I don't do this, it won't work, strange.
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GCN?useSSL=false", "root", "DAN1945mor");
        }
        catch (SQLException ex) {
            System.out.println("Oh no! Something went wrong when connecting to the database");
            ex.printStackTrace();
        }
        return con;
    }

    public void newDbBike(Bikes b) {
        try {

            Connection con = conDb();

            /**
             * need to make sql table
             */

            String addBike = "INSERT INTO Bikes() VALUES (?,?,?,?,?)";

            PreparedStatement state = con.prepareStatement(addBike);
            state.setString(1, b.getName());
            state.setString(2, b.getBrandName());
            state.setString(3, b.getComponent());
            state.setInt(4, b.getWeight());
            state.setInt(5, b.getPrice());

            state.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println("Something went wrong when creating a new bike");
            ex.printStackTrace();
        }
    }

    public void getAllRegisterCars(){}
}
