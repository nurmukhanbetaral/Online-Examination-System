import java.util.Objects;

// Абстрактный класс (Принцип Абстракции)
abstract class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public abstract String getRole(); // Абстрактный метод (Полиморфизм)
}

// Наследование
public class Candidate extends User {
    private int id;
    private int score;

    public Candidate(int id, String name) {
        super(name);
        this.id = id;
        this.score = 0;
    }

    public int getId() { return id; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    @Override
    public String getRole() {
        return "Candidate";
    }

    // Переопределение toString (для вывода в консоль)
    @Override
    public String toString() {
        return "ID: " + id + " | Имя: " + getName() + " | Баллы: " + score;
    }

    // Переопределение equals (сравнение по ID)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return id == candidate.id;
    }

    // Переопределение hashCode
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}