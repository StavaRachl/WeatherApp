package ru.stavarachi.config;

import io.github.cdimascio.dotenv.Dotenv;

public class BotConfig {
    private final Dotenv dotenv = Dotenv.load();

    private final String weatherToken = dotenv.get("WEATHER_TOKEN");
    private final String botToken = dotenv.get("TELEGRAM_TOKEN");
    private final String userName = dotenv.get("BOT_USERNAME");

    public String getBotToken() {
        return botToken;
    }

    public String getUserName() {
        return userName;
    }

    public String getWeatherToken() {
        return weatherToken;
    }
}
