import java.util.*;
import java.util.stream.Collectors;

public class Exam {
    private String examName;
    private List<Candidate> candidates;
    private List<Question> questions;

    public Exam(String examName) {
        this.examName = examName;
        this.candidates = new ArrayList<>();
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question q) { questions.add(q); }
    public void addCandidate(Candidate c) { candidates.add(c); }

    // РАНДОМ: Выбор случайных вопросов
    public List<Question> getRandomQuestions(int count) {
        List<Question> shuffled = new ArrayList<>(questions);
        Collections.shuffle(shuffled);
        return shuffled.subList(0, Math.min(count, shuffled.size()));
    }

    // ПОИСК по ID
    public Candidate findCandidate(int id) {
        return candidates.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // СОРТИРОВКА по баллам
    public void sortCandidatesByScore() {
        candidates.sort((c1, c2) -> Integer.compare(c2.getScore(), c1.getScore()));
    }

    // ФИЛЬТРАЦИЯ (например, поиск отличников)
    public List<Candidate> getTopCandidates(int threshold) {
        return candidates.stream()
                .filter(c -> c.getScore() >= threshold)
                .collect(Collectors.toList());
    }

    public void printAllResults() {
        System.out.println("\n--- Результаты экзамена: " + examName + " ---");
        for (Candidate c : candidates) {
            System.out.println(c);
        }
    }
}