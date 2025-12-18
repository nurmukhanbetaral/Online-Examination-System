import java.util.ArrayList;

public class Exam {
    private String examName;
    private Candidate candidate;
    private ArrayList<Question> questions;

    public Exam(String examName, Candidate candidate) {
        this.examName = examName;
        this.candidate = candidate;
        this.questions = new ArrayList<>();
    }

    public String getExamName() { return examName; }
    public Candidate getCandidate() { return candidate; }
    public ArrayList<Question> getQuestions() { return questions; }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void printExam() {
        System.out.println("Exam: " + examName + " for candidate " + candidate.getName());
        for (Question q : questions) {
            q.printQuestion();
        }
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examName='" + examName + '\'' +
                ", candidate=" + candidate.getName() +
                ", questions=" + questions.size() +
                '}';
    }
}

