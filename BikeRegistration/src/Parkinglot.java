import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Parkinglot {

    public void menu() throws SQLException {
        System.out.println("\n--------------------------------------------------");
        System.out.println("        Welcome to the Parking Lot");
        System.out.println("--------------------------------------------------\n");
        menuOptions();


        }


        public void menuOptions(){
            List<String> menuOptions = Arrays.asList(
                    "Do you want park here?",
                    "See if there is any available parking place",
                    "See if you have parked already",
                    "Exit the Parking Lot");


            int i = 0;
            for(String x : menuOptions) {
                System.out.println(i + ". " + x);
                i = i + 1;
            }
        }

        /*
            Admin only can see
            "List of all Owner"
            "Cars Models and how long the Owner parked for ",

            case "3":
                    listOfCars();
                    System.out.println("----------------------");
                    menuOptions();
                    break;

                case "4":
                    // have to edit
                    Database d = new Database();
                    d.getAllOwners();
                    menuOptions();
                    break;

                    DL 49166
        */

        public void newUser(){
            System.out.println("Please enter your License plate eg. DL 60000");
            Database d = new Database();
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            String license = input;
            System.out.println("How long would you want to park here for?");
            input = scan.nextLine();


            /**
             * Time Calculation
             */
        }


        public void showForOneOwner(){}
        public void showAvailableParking(){}
        public void listOfCars(){}











}


