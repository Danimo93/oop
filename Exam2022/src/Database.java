import java.sql.*;
import java.util.ArrayList;

public class Database {

    public Database(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException ex){
            System.out.println("Driver error");
            ex.printStackTrace();
        }
    }


    //I found it was just as well to have one single method that's job it is to connect to the database, this way I can just call on this method
    //when I need to create a connection, much less code rep and again, it looks fancy :D

    //NB! don't forget to add you root password to the DriverManager :-)
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


    //this adds a new user to the score table, that's it, that's all I want this method to do
    public void newDbUser(User u) {
        try {

        Connection con = conDb();

        String addUser = "INSERT INTO score(user, score, topic) VALUES (?,?,?)";

        PreparedStatement state = con.prepareStatement(addUser);
        state.setString(1, u.getName());
        state.setInt(2, u.getScore());
        state.setString(3, u.getTopic());

        state.executeUpdate();
        }
        catch (SQLException ex){
            System.out.println("Something went wrong when creating a new user");
            ex.printStackTrace();
        }
    }

    //The "map" for the resultset from listAllUser(), here I am only interested in the usernames
    //I ended up not using this, but I am leaving it inn, with listAllUser(), as a Reminder to not get too ambitious with my plans...
    public User map1(ResultSet r) throws SQLException {
        User u = new User();

        u.setName(r.getString("user"));

        return u;
    }

    public ArrayList<User> listAllUser() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        Connection con = conDb();
        Statement state = con.createStatement();
        String getUsers = "SELECT user FROM score";

        ResultSet resSet = state.executeQuery(getUsers);

        while (resSet.next()){
            users.add(map1(resSet));
        }
        return users;
    }


    //This method should also tell you what topic that sum of points if from, damnit why didn't I think of that before making it...
    // If I have time I'll come back to this. TODO
    public void scoreForOneDb(String name) {
        try {

            Connection con = conDb();

            ArrayList<Integer> points = new ArrayList<>();

            String findUser = "SELECT score from score where user = ?";

            PreparedStatement state = con.prepareStatement(findUser);
            state.setString(1, name);
            ResultSet resSet = state.executeQuery();

            while (resSet.next()){
                points.add(scoreMap(resSet));
            }
            System.out.println("User " + name + " has this score: " + points +"\n");
        }
        catch (SQLException ex){
            System.out.println("Something is wrong, can't get this form the database");
            ex.printStackTrace();
        }
    }
    //scoreMap belongs to scoreForOneDb, this was the only/easies way I know of getting it to print the points to console
    //someone with more experience with Java would know a better way, alas here I am :/
    public int scoreMap(ResultSet r) throws SQLException {
        int points;

        points = (r.getInt("score"));

        return points;
    }

    //These two methods get the top tree user scores for the database depending on topic.
    public void selectTop3History(){
        try {

            Connection con = conDb();

            String top3 = "SELECT user, score FROM score WHERE topic = 'History' order by score desc limit 3";

            Statement state = con.createStatement();

            ResultSet rs = state.executeQuery(top3);

            while (rs.next()){
                System.out.println("User: " + rs.getString("user") + " has this many point: " + rs.getInt("score"));
            }
        }
        catch (SQLException ex){
            System.out.println("Hmmmm... something is wrong with this method");
            ex.printStackTrace();
        }
    }

    public void selectTop3Boxing(){
        try {

            Connection con = conDb();

            String top3 = "SELECT user, score FROM score WHERE topic = 'Boxing' order by score desc limit 3";

            Statement state = con.createStatement();

            ResultSet rs = state.executeQuery(top3);

            while (rs.next()){
                System.out.println("User: " + rs.getString("user") + " has this many point: " + rs.getInt("score"));
            }
        }
        catch (SQLException ex){
            System.out.println("Hmmmm... something is wrong with this method");
            ex.printStackTrace();
        }
    }

    //This methods job is to update the points of the user after it has finished one of the quiz's, it works with both historyQuestions() and
    // boxingQuestions(). It gets the points and the corresponding user and updates that users point in the database
    public void updatePoints(int points, User u) throws SQLException {
        Connection con = conDb();

        String update = "UPDATE score set score = ? where user = ?";

        PreparedStatement state = con.prepareStatement(update);
        state.setInt(1, points);
        state.setString(2, u.getName());

        state.executeUpdate();
    }

    //This method job is to retive everything from the score table and then return an array that can be printed out.
    public void getAllPoints() {

        try {

            Connection con = conDb();

            String select = "SELECT * FROM score ORDER BY score DESC";

            Statement state = con.createStatement();

            ResultSet rs = state.executeQuery(select);

            while (rs.next()){
                System.out.println("User " + rs.getString("user") + " has this score: "
                        + rs.getInt("score") + " in the " + rs.getString("topic") + " topic\n");
            }
        }
        catch (SQLException ex){
            System.out.println("Something went wrong when trying to retive all the scores from the database");
            System.out.println(ex);
        }
    }


    //This was just for testing
    public void printArray() throws SQLException {
        ArrayList<User> users = listAllUser();

        for (User x: users) {
            System.out.println("Usernam:  " + x.getName());
            System.out.println("------------------\n");
        }
    }
}
