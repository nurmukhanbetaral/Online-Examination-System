public class Question {
    private int id;
    private String text;
    private String correctAnswer;

    public Question(int id, String text, String correctAnswer) {
        this.id = id;
        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    public String getText() { return text; }
    public String getCorrectAnswer() { return correctAnswer; }

    @Override
    public String toString() {
        return "Вопрос #" + id + ": " + text;
    }
}