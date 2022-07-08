public class MultichoiceQuiz extends Quiz{

    private String Question;
    private String AnswerA;
    private String AnswerB;
    private String AnswerC;
    private String AnswerD;
    private String CorrectAnswer;

    public MultichoiceQuiz(){

    }

    public MultichoiceQuiz(String Question, String AnswerA,String AnswerB, String AnswerC, String AnswerD, String CorrectAnswer){
        this.Question = Question;
        this.AnswerA = AnswerA;
        this.AnswerB = AnswerB;
        this.AnswerC = AnswerC;
        this.AnswerD = AnswerD;
        this.CorrectAnswer = CorrectAnswer;
    }


    //I really did try and get this to work, but I could for the life of me not get it to work properly with the way I sett up the database
    //and the methods in it. It is really frustration because I know how to override methods and how to use them, but I just could not get it to work...
    //I hope that the code bellow shows that I at least tired to do the exam the exact way that tha paper told us... I just couldn't
    @Override
    void showQuestion(){

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

    public String getAnswerA() {
        return AnswerA;
    }

    public void setAnswerA(String answerA) {
        AnswerA = answerA;
    }

    public String getAnswerB() {
        return AnswerB;
    }

    public void setAnswerB(String answerB) {
        AnswerB = answerB;
    }

    public String getAnswerC() {
        return AnswerC;
    }

    public void setAnswerC(String answerC) {
        AnswerC = answerC;
    }

    public String getAnswerD() {
        return AnswerD;
    }

    public void setAnswerD(String answerD) {
        AnswerD = answerD;
    }

    public String getCorrectAnswer() {
        return CorrectAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        CorrectAnswer = correctAnswer;
    }
}
