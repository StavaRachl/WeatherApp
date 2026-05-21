package ru.stavarachi.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.stavarachi.config.BotConfig;

public class Application {
    BotConfig botConfig = new BotConfig();
    private final Logger logger = LoggerFactory.getLogger(Application.class);

    public void initialize() {
        try {
            logger.info("Initializing bot...");
            String token = botConfig.getBotToken();
            String name = botConfig.getUserName();

            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            botsApi.registerBot(new BotApplication(name, token));

            logger.info("Bot success initialize");
        } catch (TelegramApiException e) {
            logger.error("Telegram error: ", e);
        }
    }
}
