import java.util.*;

public class Main {
    public static void main(String[] args) {
        DatabaseManager db = new DatabaseManager();
        Scanner scanner = new Scanner(System.in);

        List<Question> dbQuestions = db.getAllQuestions();
        if (dbQuestions.isEmpty()) {
            System.out.println("База вопросов пуста! Сначала выполните SQL INSERT.");
            return;
        }
        System.out.println("Добро пожаловать в систему экзаменов!");
        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();
        db.addCandidate(name);

        int currentCandidateId = 1;

        int score = 0;
        System.out.println("\n--- Начало теста ---");

        Collections.shuffle(dbQuestions);

        for (Question q : dbQuestions) {
            System.out.println(q.getText());
            System.out.print("Ответ: ");
            if (scanner.nextLine().equalsIgnoreCase(q.getCorrectAnswer())) {
                score++;
                System.out.println("Правильно!");
            } else {
                System.out.println("Неверно.");
            }
        }

        System.out.println("\nВаш итоговый результат: " + score);
        db.updateScore(currentCandidateId, score);


        scanner.close();
    }
}