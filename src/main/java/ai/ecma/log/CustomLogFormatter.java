package ai.ecma.log;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Created by: Mehrojbek
 * DateTime: 25/09/24 21:19
 **/
public class CustomLogFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        Throwable thrown = record.getThrown();
        if (thrown != null) {
            try {
                StringWriter sw = new StringWriter();
                thrown.printStackTrace(new PrintWriter(sw));
                String errorMsg = sw.toString();
                return "DateTime: %s, Level: %s, Message: %s, Thread: %s, LoggerName: %s\n exception: %s\n"
                        .formatted(
                                LocalDateTime.now(),
                                record.getLevel(),
                                record.getMessage(),
                                record.getLongThreadID(),
                                record.getLoggerName(),
                                errorMsg
                        );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        return "DateTime: %s, Level: %s, Message: %s, Thread: %s, LoggerName: %s\n"
                .formatted(
                        LocalDateTime.now(),
                        record.getLevel(),
                        record.getMessage(),
                        record.getLongThreadID(),
                        record.getLoggerName()
                );
    }
}
