public class Book {
    private String title;
    private String author;
    private int numberOfPages;
    private Genre genre;
    private Chapter[] chapters;

    public Book(String title, String author,
                int numberOfPages, Genre genre,
                Chapter[] chapters) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.chapters = chapters;
    }

    public String getTitle()
    {return this.title;}

    public void setTitle(String title)
    {this.title = title;}

    public String getAuthor()
    {return this.author;}

    public void setAuthor(String author)
    {this.author = author;}

    public int getNumberOfPages()
    {return this.numberOfPages;}

    public void setNumberOfPages(int numberOfPages)
    {this.numberOfPages = numberOfPages;}

    public Genre getGenre()
    {return this.genre;}

    public void setGenre(Genre genre)
    {this.genre = genre;}

    public void printState(){
        System.out.println("Title:" + title
                + ", Author:" + author
                + ", NumberOfPages:" + numberOfPages
                + ", Genre:" + genre);
        System.out.println("Chapter: ");
        for (Chapter chapter : chapters) {
            chapter.printChapterInformation();
        }
    }

}
