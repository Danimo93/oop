package controller;

import user.User;
import user.db.JDBCOps;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserRegister {

    private ArrayList<User> registeredUsers = new ArrayList<>();
    private JDBCOps dbOps = new JDBCOps();

    public void registeredUsers(User newUser){
        //  Before attempting to register my new user, I want to ensure it's a valid object.
        if(!validateUser(newUser)){
            throw new IllegalArgumentException("Something is wrong with your user");
        }

        registeredUsers.add(newUser);

        //This might also be where I add my new user to DB!
    }


    public boolean initFromDb(){
        registeredUsers = dbOps.readUsers();
        return true;
    }

    public boolean initFromFile(String file){
        try {
            Scanner fileReader = new Scanner(new File(file));
            while (fileReader.hasNextLine()) {
                String personnummerString = fileReader.nextLine();
                String name = fileReader.nextLine();
                String dob = fileReader.nextLine();
                String empId = fileReader.nextLine();
                String campus = fileReader.nextLine();
                String school = fileReader.nextLine();

                String delimiter = fileReader.nextLine();
                assert delimiter.equalsIgnoreCase("---");

                User newUser = new User();
                newUser.setPersonnummer(Long.parseLong(personnummerString));
                newUser.setName(name);
                newUser.setDateOfBirth(LocalDate.parse(dob));
                newUser.setUserId(Long.parseLong(empId));

                registeredUsers.add(newUser);
            }
        }
        catch (IOException exception){
            exception.printStackTrace();
            return false;
        }
        return false;
    }

    public ArrayList<User> getRegisteredUsers(){
        ArrayList<User> result = new ArrayList<>();
        for (User user : registeredUsers) {
            result.add(user);
        }
        return result;
    }

    private boolean validateUser(User user) {
        return user.getName() != null
                && user.getSchool() != null
                && user.getPrimaryCampus() != null;
    }

    private void addUserToDB(User user){

    }

}
