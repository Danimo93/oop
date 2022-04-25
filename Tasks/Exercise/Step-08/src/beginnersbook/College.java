package beginnersbook;

public class College {
    String collegeName;
    Address collegeAddr;
    College (String name, Address addr){
        this.collegeAddr = addr;
        this.collegeName = name;
    }

    @Override
    public String toString(){
        return "College{" +
                "collegeName='" + collegeName + '\'' +
                ", collegeAddr=" + collegeAddr +
                '}';
    }
}

