package aula8.ex3;

public class Answer {
    private String answer;
    private int probability;

    public Answer(String answer, int probability) {
        this.answer = answer;
        this.probability = probability;
    }

    public String getAnswer() {
        return answer;
    }

    public int getProbability() {
        return probability;
    }
}
