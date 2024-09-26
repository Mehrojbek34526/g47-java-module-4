package ai.ecma.log;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

/**
 * Created by: Mehrojbek
 * DateTime: 25/09/24 21:25
 **/
public class CustomLogFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        Throwable thrown = record.getThrown();
        return thrown != null;
    }
}
