import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create candidates
        Candidate c1 = new Candidate(1, "Дінмұханбет");
        Candidate c2 = new Candidate(2, "Мұқағали");
        Candidate c3 = new Candidate(3, "Алал");
        Candidate c4 = new Candidate(4, "Нұрмұханбет");
        Candidate c5 = new Candidate(5, "Арман");

        // Create questions
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(1, "Сколько будет 3 + 5?", "8"));
        questions.add(new Question(2, "Какой цвет получается из синего и жёлтого?", "Зелёный"));
        questions.add(new Question(3, "Сколько дней в одной неделе?", "7"));
        questions.add(new Question(4, "Как называется наша планета?", "Земля"));
        questions.add(new Question(5, "Какое животное говорит «мяу»?", "Кошка"));
        questions.add(new Question(6, "Сколько месяцев в году?", "12"));
        questions.add(new Question(7, "Какой сейчас сезон после зимы?", "Весна"));
        questions.add(new Question(8, "Какой предмет мы используем, чтобы писать?", "Ручка"));
        questions.add(new Question(9, "Сколько ног у паука?", "8"));
        questions.add(new Question(10, "Какой фрукт обычно красного цвета?", "Яблоко"));

        // Shuffle questions (RANDOM)
        Collections.shuffle(questions);

        int score = 0;

        System.out.println("Экзамен начался!\n");

        // Ask first 5 random questions
        for (int i = 0; i < 5; i++) {
            Question q = questions.get(i);

            System.out.println("Вопрос " + (i + 1) + ": " + q.getText());
            System.out.print("Ваш ответ: ");
            String userAnswer = scanner.nextLine();

            if (userAnswer.equalsIgnoreCase(q.getCorrectAnswer())) {
                System.out.println("✅ Правильно!\n");
                score++;
            } else {
                System.out.println("❌ Неправильно!");
                System.out.println("Правильный ответ: " + q.getCorrectAnswer() + "\n");
            }
        }

        System.out.println("Экзамен завершён!");
        System.out.println("Ваш результат: " + score + " из 5");

        scanner.close();
    }
}

