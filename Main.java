public class Main {
    public static void main(String[] args) {
        // Create candidates
        Candidate c1 = new Candidate(1, "Дінмұханбет");
        Candidate c2 = new Candidate(2, "Мұқағали");
        Candidate c3 = new Candidate(3, "Алал");
        Candidate c4 = new Candidate(4, "Нұрмұханбет");
        Candidate c5 = new Candidate(5, "Арман");


        // Compare candidates
        System.out.println("Are candidates equal? " + c1.equals(c2));

        // Create questions
        Question q1 = new Question(1, "What is 2+2?", "4");
        Question q2 = new Question(2, "Capital of France?", "Paris");

        // Create exam
        Exam exam1 = new Exam("Java Basics", c1);
        exam1.addQuestion(q1);
        exam1.addQuestion(q2);

        // Output exam
        exam1.printExam();

        // Output objects
        System.out.println("\nObjects:");
        System.out.println(c1);
        System.out.println(q1);
        System.out.println(exam1);
    }
}
