import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "Nurik.07";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    // --- CREATE (Запись данных) ---
    public void addCandidate(String name) {
        String sql = "INSERT INTO candidates(name, score) VALUES(?, 0)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Кандидат добавлен в БД.");
        } catch (SQLException e) { System.out.println(e.getMessage()); }
    }

    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM questions";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                questions.add(new Question(rs.getInt("id"), rs.getString("text"), rs.getString("correct_answer")));
            }
        } catch (SQLException e) { System.out.println(e.getMessage()); }
        return questions;
    }

    public void updateScore(int id, int newScore) {
        String sql = "UPDATE candidates SET score = ? WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, newScore);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Результат обновлен в БД.");
        } catch (SQLException e) { System.out.println(e.getMessage()); }
    }

    public void deleteCandidate(int id) {
        String sql = "DELETE FROM candidates WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Кандидат удален из БД.");
        } catch (SQLException e) { System.out.println(e.getMessage()); }
    }
}