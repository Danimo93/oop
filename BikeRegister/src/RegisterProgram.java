import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * Change all the code to Road Bike Related
 */



public class RegisterProgram {

    public void menu() throws SQLException {
        System.out.println("\nWelcome to Cycling Shop\nWhat do you want do?\n");
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
                    top3LightestBikes(); // Need to have this in random select
                    System.out.println("--------------------");
                    menuOptions();
                    break;

                case "3":
                    Database d = new Database();
                    d.getAllRegisteredBikes();
                    menuOptions();
                    break;

                case "4":
                    System.out.println("Have a good day");
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
                "See the one who has registered that bike",
                "Show the top 3 lightest bikes",
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
        System.out.println("For Registering Bikes press 1:\nGoing back to the menu press 2:");

        input = scan.nextLine();
        //String kind = input;
        //String component = input;
        //int weight = Integer.parseInt(input);
        //int price = Integer.parseInt(input);

        int option = Integer.parseInt(input);

        if (option == 1) {
            Bikes b = new Bikes(name, "", "", 0 , 0);
            data.newDbBike(b);
            inputBikes(b);
        }else if (option == 2) {
            menu();
        }

        // registered for Mountain bike and RoadBike

    }

    public void seeOneRegisterBike(){
        System.out.println("What is the brand name of the bike you want to see?");

        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();

        Database data = new Database();

        data.RegisterForOneDb(name);

    }

    public void top3LightestBikes(){
        Database data = new Database();
        data.lightestBikes();
    }

    public void inputBikes(Bikes b) throws SQLException {
        Database_Registering dataRg = new Database_Registering();
        Scanner scan = new Scanner(System.in);
        ArrayList<BikeRegistering> bikesArraysList = new ArrayList<>();
        int point = 0;
        int i = 0;

        for (BikeRegistering ignored : bikesArraysList) {
            System.out.println("Please enter what you need ");
            System.out.println(bikesArraysList.get(i).getComponent());
            System.out.println(
                    bikesArraysList.get(i).getComponentA() + ". " + " " +
                    bikesArraysList.get(i).getComponentB() + ". " + " " +
                    bikesArraysList.get(i).getComponentC() + ". ");
            if (x.getBrandName().equals(b.getBrandName())) {
                point = i;
            }
            i = i + 1;
        }
        Database data = new Database();
        data.getAllRegisteredBikes();
    }


}
