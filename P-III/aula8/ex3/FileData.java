package aula8.ex3;

public class FileData {
    private String imagePath;
    private Question[] questions;

    public FileData(String imagePath, Question[] questions) {
        this.imagePath = imagePath;
        this.questions = questions;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Question[] getQuestions() {
        return questions;
    }
}
