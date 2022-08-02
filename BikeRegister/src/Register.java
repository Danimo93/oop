import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * Change all the code to Road Bike Related
 */



public class Register {

    public void menu() throws SQLException {
        System.out.println("Register Cars \n What do you want do");
        menuOptions();
        boolean check = false;
        Scanner scan = new Scanner(System.in);

        while (!check) {

            String input = scan.next();

            switch (input) {
                case "0":
                    newBike();
                    menuOptions();
                    break;

                case "1":
                    seeOneRegisterBike();
                    menuOptions();
                    break;

                case "2":
                    top3RegistedBikes(); // Need to have this in random select
                    System.out.println("--------------------");
                    menuOptions();
                    break;

                case "3":
                    Database d = new Database();
                    d.getAllRegisterBikes();
                    menuOptions();
                    break;

                case "4":
                    System.out.println("Have a good");
                    System.exit(1);

                default:
                    System.out.println("\nNice try. Try again\n");
                    menuOptions();
            }
        }
    }
    public void menuOptions(){
        List<String> menuOptions = Arrays.asList(
                "Register your new Bike",
                "See if your Bike is registered",
                "Show the top 3 registered Bikes",
                "List all Bikes registered",
                "Exit");
        int i = 0;
        for (String x : menuOptions) {
            System.out.println(i + ". " + x);
            i = i + 1;
        }
    }

    public void newBike() throws SQLException{
        System.out.println("Please enter your name");

        Database data = new Database();

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        String name = input;

        // Hmm not sure what the im going to do with this...
        System.out.println("For Registering Road Bikes press 1:\nFor Registering Mountain Bike press 2:");

        //String kind = input;
        //String component = input;
        //int weight = Integer.parseInt(input);
        //int price = Integer.parseInt(input);

        int option = Integer.parseInt(input);

        if (option == 1) {
            Bikes b = new Bikes(name, "", "", 0 , 0);
            data.newDbBike(b);
        }


        // registered for Mountain bike and RoadBike

    }

    public void seeOneRegisterBike(){

    }

    public void top3RegistedBikes(){}


}
