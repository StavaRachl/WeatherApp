package ru.stavarachi.app;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.stavarachi.config.BotConfig;

public class Application {
    BotConfig botConfig = new BotConfig();

    public void initialize() {
        try {
            String token = botConfig.getBotToken();
            String name = botConfig.getUserName();

            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            botsApi.registerBot(new BotApplication(name, token));
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
