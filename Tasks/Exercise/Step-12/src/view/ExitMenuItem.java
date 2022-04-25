package view;

public class ExitMenuItem extends MenuItem {

    public ExitMenuItem(String text) {
        this.name = text;
    }

    @Override
    void runFunctionality() {
        // This may be where we make sure everything is safe (To file or DB)
        // This may be where we close DB connections.
        System.out.println("Exiting...");
    }
}
