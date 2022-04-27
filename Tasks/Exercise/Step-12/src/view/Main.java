package view;

import controller.UserRegister;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    HashMap<Integer, MenuItem> menuItems = new HashMap<>();
    UserRegister register;


    public static void main(String[] args) {
        Main executable = new Main();
        executable.register = new UserRegister();
        //executable.register.initFromFile("resources/users.txt");
        executable.register.initFromDb();
        Scanner userInput = new Scanner(System.in);

        executable.initMenu();
        executable.showMenu();

        Integer selection = 0;

        do {
            try {

            selection = userInput.nextInt();
            userInput.nextLine();
            }
            catch (InputMismatchException exception) {
                exception.printStackTrace();
                //selection = 0;
            }

            switch (selection) {
                case 0 -> {
                    executable.showMenu();
                }
                case 1 -> {
                    System.out.println("Exiting...");
                }
                case 2 -> {
                    // This is where I would display stuff
                    System.out.println("Displaying users...");
                    executable.menuItems.get(2).runFunctionality();
                }
                default -> {
                    System.out.println("Something didn't go right. Maybe user error.");
                    //executable.showMenu();
                }
            }
        }
        while (selection != 1);

    }

    private void showMenu() {
        for (Map.Entry<Integer, MenuItem> entry : menuItems.entrySet()) {
            System.out.println("" + entry.getKey() + " - " + entry.getValue().name);
        }

    }

    private void initMenu() {
        ExitMenuItem exit = new ExitMenuItem("Exit");
        menuItems.put(1, exit);

        ShowUserMenuItems showUser = new ShowUserMenuItems("Show user", register);
        menuItems.put(2, showUser);

    }

}
