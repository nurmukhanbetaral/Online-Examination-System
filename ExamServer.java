import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

public class ExamServer {
    // Создаем объекты для базы и JSON один раз
    private static final DatabaseManager db = new DatabaseManager();
    private static final Gson gson = new Gson();

    public static void main(String[] args) throws IOException {
        // Создаем сервер на порту 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // 1. Маршрут для ВОПРОСОВ: http://localhost:8080/api/questions
        server.createContext("/api/questions", exchange -> {
            List<Question> questions = db.getAllQuestions();
            sendJsonResponse(exchange, questions);
        });

        // 2. Маршрут для КАНДИДАТОВ: http://localhost:8080/api/candidates
        server.createContext("/api/candidates", exchange -> {
            List<Candidate> candidates = db.getAllCandidates();
            sendJsonResponse(exchange, candidates);
        });

        System.out.println("🚀 Сервер успешно запущен!");
        System.out.println("👉 Вопросы: http://localhost:8080/api/questions");
        System.out.println("👉 Кандидаты: http://localhost:8080/api/candidates");

        server.setExecutor(null);
        server.start();
    }

    // Вспомогательный метод, чтобы не писать один и тот же код отправки дважды
    private static void sendJsonResponse(HttpExchange exchange, Object data) throws IOException {
        String json = gson.toJson(data);
        byte[] response = json.getBytes("UTF-8");

        // Устанавливаем заголовки (что это JSON и кодировка UTF-8)
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(200, response.length);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response);
        }
    }
}