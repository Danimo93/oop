import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Program program = new Program();
            program.handleUserInteraction();
            } catch (IOException ioe) {
            System.out.println("Unable to run program. Are you sure the needed file exists");
            ioe.printStackTrace();
        }
    }
}
