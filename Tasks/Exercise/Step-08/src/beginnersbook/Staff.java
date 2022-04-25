package beginnersbook;

public class Staff {
    String empoyeeName;
    Address empoyeeAddr;
    Staff(String name, Address addr){
        this.empoyeeName = name;
        this.empoyeeAddr = addr;
    }
    @Override
    public  String toString(){
        return "Staff{" +
                "emplooyeeName='" + empoyeeName + '\'' +
                ", empoyeeAddr=" + empoyeeAddr +
                '}';
    }
}
