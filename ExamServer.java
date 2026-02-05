import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.List;

public class ExamServer {
    private static final DatabaseManager db = new DatabaseManager();
    private static final Gson gson = new Gson();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/api/questions", exchange -> {
            List<Question> questions = db.getAllQuestions();
            sendJsonResponse(exchange, questions);
        });

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

    private static void sendJsonResponse(HttpExchange exchange, Object data) throws IOException {
        String json = gson.toJson(data);
        byte[] response = json.getBytes("UTF-8");

        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        exchange.sendResponseHeaders(200, response.length);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response);
        }
    }
}