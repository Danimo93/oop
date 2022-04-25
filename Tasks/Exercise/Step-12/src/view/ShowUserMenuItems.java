package view;

import controller.UserRegister;
import user.User;

public class ShowUserMenuItems extends MenuItem{

    UserRegister register;

    public ShowUserMenuItems(String text, UserRegister register) {
        this.name = text;
        this.register = register;
    }


    @Override
    void runFunctionality() {
        // I might do some checks or something

        System.out.println("Showing users:");

        // I need a method that displays all the users in mind register.
        for(User user : register.getRegisteredUsers()) {
            System.out.println(user.menuInfo());
        }
    }
}
