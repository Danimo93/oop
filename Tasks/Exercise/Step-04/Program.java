

import java.util.ArrayList;
import java.util.Scanner;


public class Program {
    public void runProgram(){
        System.out.println("Program Starting...");
        //task4();
        //task6();
        task7();
    }

    private void task4() {
        Scanner input = new Scanner(System.in);

        ArrayList<String> inputValues = new ArrayList<>();
        System.out.println("need three string...");

        for (int i = 0; i < 3; i++) {
            inputValues.add(input.nextLine());
        }

        System.out.println("---ThreeValues---");
        for (String s : inputValues) {
            System.out.println(s);
        }
    }

    private void task6 () {
        Scanner inputs = new Scanner(System.in);
        int number = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Not enough");
        while (number >= 0){
            number = inputs.nextInt();
            if(number >= 0){
                numbers.add(number);
            }
        }
        int sum = 0;
        for(Integer i : numbers) {
            sum += i;
        }
        System.out.println("Sum:"+ sum);
    }
    private void task7(){
        int choice = 0;
        Scanner input = new Scanner(System.in);
        ArrayList<String> strings = new ArrayList<>();
        while(choice!=3){
            System.out.println("1. Add single word");
            System.out.println("2. Display all words");
            System.out.println("3. End");
            choice = input.nextInt();
            if (choice == 1){
                System.out.println("Write Word:");
                strings.add(input.next());
            } else if (choice == 2){
                System.out.println("Here are all the words:");
                for (String s : strings){
                    System.out.println(s);
                }
            }else {
                System.out.println("Bye!");
            }
        }
    }

}
