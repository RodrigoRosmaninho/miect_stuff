import java.util.ArrayList;

class Answer{
    private String answer;
    private Integer points;

    public Answer(String answer, Integer points){
        this.answer = answer;
        this.points = points;
    }

    public String getAnswer(){
        return answer.substring(1, answer.length() - 1);
    }

    public Integer getPoints(){
        return points;
    }
}

public class Question extends ArrayList<Answer> {
    private String question;

    public Question(String question){
        super();
        this.question = question;
    }

    public String getQuestion() {
        return question.substring(1, question.length() - 1);
    }

}
