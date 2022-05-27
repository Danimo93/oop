//
//import java.io.IOException;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
///**
// * This class is responsible for handling user input on user choices.
// * When books are to be updated, received etc. it will ask for help from the register.
// */
//public class Program {
//    // register to hold all books and offers functionality to get/add/edit etc.
//    BookRegister register;
//    // To get input from user
//    private Scanner input;
//    /**
//     * the object needs help from a book register, So why not create it in the constructor.
//     * The object will always need help to read user input. Scanner to the rescue!
//     * Without these two helpers, the object can not do its job.
//     */
//
//    public Program() throws IOException{
//        register = new BookRegister();
//        input = new Scanner(System.in);
//    }
//    /**
//     * loop to handle her user interaction until user decides to quit.
//     */
//    public void handleUserInteraction() throws IOException{
//        int choice = 0;
//        while (choice!=8){
//            printMainMenu();
//            choice = getIntegerFromUser(1, 8, "make your choice:");
//            switch (choice){
//                case 1 -> printAllBooks();
//                case 2 -> addBook();
//                case 3 -> editBook();
//                case 4 -> printBooksByGenre();
//                case 5 -> printBooksByAuthor();
//                case 6 -> printBooksByISBN();
//                case 7 -> removeBooks();
//                case 8 -> endUserInteraction();
//            }
//        }
//    }
//
//
//    private void printMainMenu(){
//        System.out.println("1: All Books");
//        System.out.println("2: Add book");
//        System.out.println("3: Edit book");
//        System.out.println("4: Find book by genre");
//        System.out.println("5: Find book by author");
//        System.out.println("6: Fine book by ISBN");
//        System.out.println("7: Remove book");
//        System.out.println("8: Quit");
//    }
//
//    private void printAllBooks(){
//        register.printAllBooks();
//    }
//
//    private void addBook(){
//        System.out.println("Enter ISBN");
//        String isbn = input.nextLine();
//        System.out.println("Enter title");
//        String title = input.nextLine();
//        System.out.println("Enter author");
//        String author = input.nextLine();
//        int pages = getIntegerFromUser(1, 10000, "Enter number of pages:");
//        Genre genre = getGenreFromUser("Enter Genre (CRIME, ACTION, FANTASY, CLASSIC OR OTHER):");
//        register.addBook(new Book(isbn, title, author, pages, genre));
//    }
//
//    private void editBook(){
//        System.out.println("Enter ISBN:");
//        String isbn = input.nextLine();
//        Book oldVersion = register.getBook(isbn);
//        if(oldVersion == null){
//            System.out.println("Unable to update book.Book not found.");
//            return;
//        }
//        System.out.println("Enter new title (current=" + oldVersion.getTitle()+"):");
//        String title = input.nextLine();
//        System.out.println("Enter new author (current=" + oldVersion.getAuthor()+"):");
//        String author = input.nextLine();
//        int pages = getIntegerFromUser (1, 10000, "Enter number of pages (current=" + oldVersion.getNumberOfPages()+"):");
//        Genre genre = getGenreFromUser("Enter Genre (CRIME, ACTION, FANTASY, CLASSIC or OTHER): ""Current="+ oldVersion.getGenre().name());
//        Book newVersion = new Book(isbn, title, author, pages, genre);
//        register.editBook(oldVersion, newVersion);
//    }
//
//    private void printBooksByGenre(){
//        Genre genre = getGenreFromUser("Enter GENRE((CRIME, ACTION, FANTASY, CLASSIC OR OTHER):)")
//        register.printBooksByGenre(genre);
//    }
//
//    private void printBooksByAuthor(){
//        System.out.println("Enter author:");
//        String author = input.nextLine();
//        register.printBooksByAuthor(author);
//    }
//
//    private void printBooksByISBN(){
//        System.out.println("Enter ISBN");
//        String isbn = input.nextLine();
//        register.printBooksByISBN(isbn);
//    }
//
//    private void removeBooks(){
//        System.out.println("Enter ISBN:");
//        String isbn = input.nextLine();
//        register.removeBooks(isbn);
//    }
//
//
//    private void endUserInteraction() throws IOException{
//        System.out.println("Thank you for using this amazing book register Bye");
//    }
//
//    /**
//     * Making sure a valid int Is provided by user.
//     * Looping until The valid int is provided.
//     * Ask the method will be called in multiple Situation,
//     * We need Parameters to decide the valid range and prompt to the user.
//     *
//     */
//
//    private int getIntegerFromUser(int minValue, int maxValue, String prompt){
//        String errorMessage = "That is not a number between" + minValue + " and" + maxValue;
//        int choice = minValue -1;
//        while(choice < minValue || choice > maxValue){
//            System.out.println(prompt);
//            try {
//                choice = input.nextInt();
//            }catch (InputMismatchException inputMismatchException){
//                System.out.println(errorMessage);
//            }
//            if (choice < minValue || choice > maxValue) {
//                System.out.println(errorMessage);
//
//            }
//        }
//        input.nextLine(); // reading CR
//        return choice;
//    }
//
//}
//