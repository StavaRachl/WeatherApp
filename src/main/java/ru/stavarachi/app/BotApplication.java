package ru.stavarachi.app;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.stavarachi.handler.CommandHandler;

public class BotApplication extends TelegramLongPollingBot {
    private final String userName;
    CommandHandler commandHandler;


    public BotApplication(String userName, String botToken) {
        this.userName = userName;
        super(botToken);
        this.commandHandler = new CommandHandler();
    }

    @Override
    public void onUpdateReceived(Update update) {
        commandHandler.handle(update, this);
    }

    @Override
    public String getBotUsername() {
        return userName;
    }
}
