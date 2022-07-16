import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parkinglot {
    public void menu() throws SQLException{
        System.out.println("--------------------------------------------------");
        System.out.println("        Welcome to the Parking Lot");
        System.out.println("--------------------------------------------------\n");
        menuOptions();
        boolean check = false;
        Scanner scan = new Scanner(System.in);

        while (!check){

            String input = scan.next();

            switch (input){
                // register a new Cars
                case "0":
                    newUser();
                    menuOptions();
                    break;

                // Show the One Onwer
                case "1":
                    // have to edit
                    showForOneOwner();
                    menuOptions();
                    break;

                // show available pakring pace
                case "2":
                    // have to edit
                    showAvailablePaking();
                    System.out.println("----------------------");
                    menuOptions();
                    break;


                case "3":
                    System.out.println("----------------------");
                    menuOptions();
                    break;

                case "4":
                    // have to edit
                    Database d = new Database();
                    d.getAllOwners();
                    menuOptions();
                    break;

                case "5":
                    System.out.println("Goodbye and welcome again");
                    System.exit(1);

                default:
                    System.out.println("Not a valid option, try again\n");
                    menuOptions();

            }

        }

        public void menuOptions(){
            List<String> menuOptions = new ArrayList<"Register Owner", " ", "", "", "">();
            int i = 0;
            for(String x : menuOptions) {
                System.out.println(i + ". " + x);
                i = i + 1;
            }
        }
    }
}

