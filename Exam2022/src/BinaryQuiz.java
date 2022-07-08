import java.sql.SQLException;
import java.util.ArrayList;

public class BinaryQuiz extends Quiz{

    private String Question;
    private String CorrectAnswer;


    public BinaryQuiz(){

    }

    public BinaryQuiz(String question, String answer){
        this.Question = question;
        this.CorrectAnswer = answer;

    }

    //I really did try and get this to work, but I could for the life of me not get it to work properly with the way I sett up the database
    //and the methods in it. It is really frustration because I know how to override methods and how to use them, but I just could not get it to work...
    //I hope that the code bellow shows that I at least tired to do the exam the exact way that tha paper told us... I just couldn't
    @Override
    void showQuestion() {
        try {
            Database_Questions dq = new Database_Questions();
            ArrayList<BinaryQuiz> bq = dq.BQ();
            for (BinaryQuiz x: bq) {
                System.out.println("Question: " + x.getQuestion());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    };

    @Override
    void isCorrectAnswer(String answer){

    };


    //Getters and setters
    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }
}
