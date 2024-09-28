package ai.ecma.log;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

/**
 * Created by: Mehrojbek
 * DateTime: 25/09/24 21:42
 **/
public class TelegramLogHandler extends StreamHandler {
    private final Formatter formatter;
    private final Filter filter;

    public TelegramLogHandler(Formatter formatter, Filter filter) {
        this.formatter = formatter;
        this.filter = filter;
    }

    @Override
    public void publish(LogRecord record) {

        boolean loggable = filter.isLoggable(record);
        if (!loggable)
            return;

        String formattedText = formatter.format(record);

        String botToken = "5290026677:AAHryiAxZMpf32A6zHk3PyRM20XhSn-ahYY";
        String chatId = "354668188";
        String url = ("https://api.telegram.org/bot" + botToken + "/sendMessage");

        String bodyJson = """
                {
                "text": "%s",
                "chat_id": %s,
                }
                """.formatted(formattedText, chatId);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(bodyJson))
                    .uri(URI.create(url))
                    .setHeader("Content-Type", "application/json")
                    .build();
            client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
