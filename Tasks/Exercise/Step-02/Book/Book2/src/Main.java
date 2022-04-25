public class Main {
    public static void main(String[] args) {
        BookRegister register = new BookRegister(20);

        Chapter[] hpChapter = new Chapter[3];
        hpChapter[0] = new Chapter("Chapter 1", 20, 2);
        hpChapter[1] = new Chapter("Chapter 2", 18, 2);
        hpChapter[2] = new Chapter("Chapter 3", 19, 2);

        Book book1 = new Book("Harry Potter and the Sorcerer's Stone",
                "J.K Rowling", 400, Genre.FANTASY, hpChapter);
        register.addBook(book1);

        Chapter[] sultChapter = new Chapter[2];
        sultChapter[0] = new Chapter("Chapter 1", 20, 2);
        sultChapter[1] = new Chapter("Chapter 2", 18, 2);

        Book book2 = new Book("Sult",
                "Knut Hamsun", 115, Genre.ACTION, sultChapter);
        register.addBook(book2);

        System.out.println("Printing all books:");
        register.printAllBook();
        System.out.println("Printing books by genre:");
        register.printBooksByGenre(Genre.FANTASY);
        System.out.println("Printing books by author:");
        register.printBooksByAuthor("J.K. Rowling");

        // But as we follow the principle of Encapsulation I may not get or set the fields directly:
        //String hpAuthor = hp.author;
        //hp.numberOfPages = 123:
        // You may try by removing the comments and the two lines above. Won't work :)


    }
}
