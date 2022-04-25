package beginnersbook;

public class Main {
    public static void main(String[] args) {
        Address a1 = new Address("Krikegata 24", 0107, "Oslo", "Oslo", "Norge");
        Address a2 = new Address("Likesomyeien 2", 5007, "Bergen", "Vestland", "Norge");
        Address a3 = new Address("Greverudveien 99", 1415, "Oppgård", "Viken", "Norge");
        Student student = new Student (123, "Hansen Hansen", a2);
        Staff staff = new Staff("Frod Foreleser", a3);
        College college = new College("Høyskolen Kristiania", a1);

        System.out.printf("Student: %s%n", student);
        System.out.printf("Staff: %s%n", staff);
        System.out.printf("College: %s%n", college);

    }
}
