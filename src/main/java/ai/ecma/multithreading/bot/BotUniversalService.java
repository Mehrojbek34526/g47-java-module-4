package ai.ecma.multithreading.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: Mehrojbek
 * DateTime: 04/09/24 21:37
 **/
public class BotUniversalService extends TelegramLongPollingBot {
    private final String username;
    private final String token;

    public BotUniversalService(String username, String token) {
        this.username = username;
        this.token = token;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            Message message = update.getMessage();

//            if (message.hasLocation()) {
//                SendMessage sendMessage = new SendMessage();
//                sendMessage.setChatId(message.getChatId().toString());
//                sendMessage.setText("Knopka yo'qoldi");
//                sendMessage.setReplyMarkup(new ReplyKeyboardRemove(true));
//                try {
//                    execute(sendMessage);
//                } catch (TelegramApiException e) {
//                    throw new RuntimeException(e);
//                }
//                return;
//            }

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId());
            sendMessage.setText("%s dan salom".formatted(username));

            List<KeyboardRow> rowList = new ArrayList<>();
            KeyboardRow row1 = new KeyboardRow();
            KeyboardButton button1 = new KeyboardButton();
            button1.setText("Share location");
//            button.setRequestContact(true);
            button1.setRequestLocation(true);

            KeyboardButton button2 = new KeyboardButton();
            button2.setText("Share phone");
            button2.setRequestContact(true);

            row1.add(button1);
            row1.add(button2);

            KeyboardRow row2 = new KeyboardRow();
            row2.add("second row btn");

            rowList.add(row1);
            rowList.add(row2);

            ReplyKeyboardMarkup replyMarkup = new ReplyKeyboardMarkup();
            replyMarkup.setResizeKeyboard(true);
            replyMarkup.setKeyboard(rowList);

            sendMessage.setReplyMarkup(replyMarkup);

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }

        }

    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
