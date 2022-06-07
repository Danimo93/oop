package user;

public class User extends Person{
    long userId;
    Campus primaryCampus;

    School school;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Campus getPrimaryCampus() {
        return primaryCampus;
    }

    public void setPrimaryCampus(Campus primaryCampus) {
        this.primaryCampus = primaryCampus;
    }

    public void setPrimaryCampus(String primaryCampus) {
        Campus campus = Campus.valueOf(primaryCampus);
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String menuInfo(){
        return "" + this.name + " -> " +  this.userId + " - " ;
    }
}
