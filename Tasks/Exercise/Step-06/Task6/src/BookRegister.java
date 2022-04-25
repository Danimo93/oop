import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class BookRegister {
    private ArrayList<Book> books = new ArrayList<>();
    private String booksFileName;

    public BookRegister() throws IOException {
        //books = new ArrayList<>();
        booksFileName = "bok.txt";
        readBooksFromFile(booksFileName);
    }

    public void writeBooksToFile() throws IOException {
        FileWriter fileWriter = new FileWriter(booksFileName);
        for (int i = 0; i < books.size(); i++) {
            fileWriter.writer(books.get(i).getIsbn() + "\n");
            fileWriter.writer(books.get(i).getTitle() + "\n");
            fileWriter.writer(books.get(i).getAuthor() + "\n");
            fileWriter.writer(books.get(i).getNumberOfPages() + "\n");
            fileWriter.writer(books.get(i).getGenre().name() + "\n");
            fileWriter.writer("---");
            if (i != books.size() - 1) { // To avoid CR in end of file
                fileWriter.writer("\n");
            }
        }
        fileWriter.close();
    }

    public void printBooksByISBN(String isbn){
        boolean found = false;
        for (Book b : books) {
            if (b.getIsbn().equalsIgnoreCase(isbn)){
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No book with isbn="+isbn);
        }
    }

    public void printBooksByAuthor(String author){
        System.out.println("All books by author"+ author);
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)){
                b.printState();
            }
        }
    }

    public void printBooksByGenre(Genre genre){
        System.out.println("All books in genre:"+genre.name());
        for (Book b: books) {
            if (b.getGenre() == genre) {
                b.printState();
            }
        }
    }

    /**
     * Holding box in an area last is not optimal (What is what we currently know).
     * Editing a book is handled by removing the old version and adding the new.
     * Validating that there is an ISBN match in old add new version.
     *
     * If we hide our books in a map, things would be easier.
     */

    public void editBook(Book oldVersion, Book newVersion){
        if(!(oldVersion.getIsbn().equalsIgnoreCase(newVersion.getIsbn()))){
            System.out.println("Unable to update box. ISBN mismatch.");
            return;
        }
        books.remove(oldVersion);
        books.add(newVersion);
        System.out.println("Book update");
    }

    private void readBooksFromFile(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String isbn = input.nextLine();
            String title = input.nextLine();
            String author = input.nextLine();
            int pages = input.nextInt();
            input.nextLine();
            Genre genre = Genre.valueOf(input.nextLine());
            input.nextLine();
            books.add(new Book(isbn, title, author, pages, genre));
        }
    }

    public void printAllBooks(){
        for (Book b : books){
            b.printState();
        }
    }

    public void addBook(Book book){books.add(book);}

    public Book getBook(String isbn){
        for(Book b : books){
            if (b.getIsbn().equalsIgnoreCase(isbn)){
                return b;
            }
        }
        return null;
    }

    public void removeBooks(String isbn) {
        Book b = getBook(isbn);
        if (b == null) {
            System.out.println("Unable to remove book. Book not found.");
            return;
        }
        books.remove(b);
        System.out.println("Book removed");
    }
}
