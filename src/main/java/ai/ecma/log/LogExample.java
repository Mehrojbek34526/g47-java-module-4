package ai.ecma.log;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by: Mehrojbek
 * DateTime: 25/09/24 20:57
 **/
public class LogExample {

    static Logger logger = Logger.getLogger(LogExample.class.getName());

    public static void main(String[] args) throws IOException {

        FileHandler handler = new FileHandler("logs/project.log", true);
        handler.setFormatter(new CustomLogFormatter());

        logger.addHandler(handler);
        logger.addHandler(new TelegramLogHandler(new CustomLogFormatter(), new CustomLogFilter()));

//        logger.setLevel();

        logger.setFilter(new CustomLogFilter());

        logger.info("Test uchun log yozildi");

        try {
            if (true) {
                throw new RuntimeException("Xatolik bo'ldi");
            }
        } catch (RuntimeException e) {
            System.out.println("Xatolik bo'ldi");
//            logger.log(Level.INFO, "This is InFo log",e);
            logger.log(Level.SEVERE, "Xatolik bo'ldi -> ", e);
//            logger.severe("Xatolik bo'ldi -> " + e.getMessage());
        }

        System.out.println("Keyingi qator");


    }

}
