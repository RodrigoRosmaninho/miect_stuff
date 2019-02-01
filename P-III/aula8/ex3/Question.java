package aula8.ex3;

public class Question {
    private String question;
    private Answer[] answers;
    private Answer correctAnswer;
    private int dificulty;
    private String image;

    public Question(String question, Answer[] answers, Answer correctAnswer, int dificulty, String image) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
        this.dificulty = dificulty;
        this.image = image;
    }

    public String getQuestion() {
        return question;
    }

    public Answer[] getAnswers() {
        return answers;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public int getDificulty() {
        return dificulty;
    }

    public String getImage() {
        return image;
    }
}
