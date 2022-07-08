public class User {

    //I named the class User and not 'UserScore' because it made more sense to me to name it this.

    private String Name;
    private int Score;
    private String Topic;

    public User(){

    }

    //this is not really in use anymore
    public User(String name){
        this.Name = name;
    }


    //The way my program ended up it makes sense that an object of type User also has a topic, in my original plan for this program it did not
    //as an object of type User was meant to be able to have more than just one topic, oh well, it's a shame I could not get this to work the way I'd like it to
    public User(String name, int points, String topic){
        this.Name = name;
        this.Score = points;
        this.Topic = topic;
    }

    //Getters and setters
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }
}
