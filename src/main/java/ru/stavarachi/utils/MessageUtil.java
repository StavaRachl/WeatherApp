package ru.stavarachi.utils;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MessageUtil {
    public void sendMessage(TelegramLongPollingBot bot, Long chatId, String text) {
        try {
            SendMessage sendMessage = new SendMessage();

            sendMessage.setChatId(chatId);
            sendMessage.setText(text);

            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
