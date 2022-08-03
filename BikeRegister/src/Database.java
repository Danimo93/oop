import java.sql.*;
import java.util.ArrayList;

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

            String addBike = "INSERT INTO RegisterBikes(NAME, BRANDNAME, COMPONENT, WEIGHT, PRICE) VALUES (?,?,?,?,?)";

            PreparedStatement state = con.prepareStatement(addBike);
            state.setString(1, b.getName());
            state.setString(2, b.getBrandName());
            state.setString(3, b.getComponent());
            state.setDouble(4, b.getWeight());
            state.setDouble(5, b.getPrice());

            state.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println("Something went wrong when creating a new bike");
            ex.printStackTrace();
        }
    }


    // Who Has registered a this bike brand?

    /**
     * This function works.
     * The Search engine works with finding the name.
     * but it only returns the first result not brand name.
     * as the end game is to find the brand name.
     * and who has registered it.
     *
     */

    public void RegisterForOneDb(String brandname) {
        try {

            Connection con = conDb();

            ArrayList<String> name = new ArrayList<>();

            String findName = "SELECT Name from RegisterBikes where BrandName = ?";

            PreparedStatement state = con.prepareStatement(findName);
            state.setString(1, String.valueOf(brandname));
            ResultSet resSet = state.executeQuery();

            while (resSet.next()){
                name.add(findBikeDb(resSet));
            }
            System.out.println("\nPerson who registered " + brandname + " bikes is registered by:\n" + name +"\n");
        }
        catch (SQLException ex){
            System.out.println("Can't get this name from the database");
            ex.printStackTrace();
        }
    }

    public String findBikeDb(ResultSet r) throws SQLException {
        String name;

        name = (r.getString("Name"));

        return name;
    }

    public void lightestBikes(){
        try {

            Connection con = conDb();

            String top3 = "SELECT * FROM RegisterBikes order by Weight asc limit 3";

            Statement state = con.createStatement();

            ResultSet rs = state.executeQuery(top3);

            while (rs.next()){
                System.out.println("\nUser: "
                        + rs.getString("Name") + " has registered "
                        + rs.getString("BrandName") + " bike with a weight of "
                        + rs.getDouble("Weight" ) + "kg");
            }
        }
        catch (SQLException ex){
            System.out.println("Hmmmm... something is wrong with this method");
            ex.printStackTrace();
        }
    }

    public void updatePoints(int points, Bikes b) throws SQLException {
        Connection con = conDb();

        String update = "UPDATE RegisterBikes SET Points = ? WHERE Name = ?";

        PreparedStatement state = con.prepareStatement(update);
        state.setInt(1, points);
        state.setString(2, b.getName());
        state.executeUpdate();
    }

    public void getAllRegisteredBikes(){

            try {

                Connection con = conDb();

                String select = "SELECT * FROM RegisterBikes ORDER BY BrandName DESC";

                Statement state = con.createStatement();

                ResultSet rs = state.executeQuery(select);

                while (rs.next()){
                    System.out.println("\nUser: "
                            + rs.getString("Name") + " has registered "
                            + rs.getString("BrandName") + " with a component of "
                            + rs.getString("Component") + " the price for this bike is "
                            + rs.getDouble("Price") + "kr" + "\n");
                }
            }
            catch (SQLException ex){
                System.out.println("Something went wrong when trying to relative all the scores from the database");
                System.out.println(ex);
            }
        }
}




