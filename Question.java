public class Question {
    private int id;
    private String text;
    private String correctAnswer;

    public Question(int id, String text, String correctAnswer) {
        this.id = id;
        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    public int getId() { return id; }
    public String getText() { return text; }
    public String getCorrectAnswer() { return correctAnswer; }

    public void setText(String text) { this.text = text; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }

    public void printQuestion() {
        System.out.println("Question #" + id + ": " + text);
    }

    @Override
    public String toString() {
        return "Question{id=" + id + ", text='" + text + "'}";
    }
}
