package ai.ecma.multithreading.bot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;

/**
 * Created by: Mehrojbek
 * DateTime: 04/09/24 21:34
 **/
public class Main {

    public static void main(String[] args) throws TelegramApiException {

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

        List<BotData> bots = List.of(
                new BotData("myNumberOneCarbot","7225524912:AAFoXfrpwOzH1cN3Zo9rgjEEAM_IWoltrLA"),
                new BotData("Hello_G47_Super_bot","6616772814:AAF3wQePht6CB4KYBSZuFqqCUyBat1J4RvI"),
                new BotData("Be_honest_MyFriend_bot","7280055119:AAEOgJ2Pcqx5uRNLJKPgmoz0YiqUgXQNe1Q"),
                new BotData("fast_n_bot","7121250935:AAG_XzMWqpB3EHBqqStV2nDJGKyeiCeW3t4")
        );

        for (BotData botData : bots) {

            BotUniversalService pollingBot = new BotUniversalService(
                    botData.username,
                    botData.token
            );

            Runnable task = () -> {
                try {
                    telegramBotsApi.registerBot(pollingBot);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            };

            new Thread(task).start();

        }

    }

    public static record BotData(String username, String token) {

    }

}
