package ru.stavarachi.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.stavarachi.config.BotConfig;
import ru.stavarachi.service.RenderService;
import ru.stavarachi.utils.MessageUtil;

public class CommandHandler {
    private final Logger logger = LoggerFactory.getLogger(CommandHandler.class);
    BotConfig botConfig = new BotConfig();
    MessageUtil messageUtil = new MessageUtil();
    RenderService renderService = new RenderService();

    public void handle(Update update, TelegramLongPollingBot bot) {
        try {
            if (!update.hasMessage() || !update.getMessage().hasText()) return;

            String command = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            if (update.getMessage().getText().startsWith("/weather")) {
                String[] parts = command.split(" ", 2);
                String city = parts[1];
                messageUtil.sendMessage(bot, chatId, renderService.renderWeather(city, botConfig.getWeatherToken()));
            } else if (command.equals("/start")) {
                messageUtil.sendMessage(bot, chatId, "Привет! Это бот погоды что бы начать введи команду /weather и город на английском например Khabarovsk");
            }
        } catch (Exception e) {
            logger.error("Error: ", e);
        }
    }
}
