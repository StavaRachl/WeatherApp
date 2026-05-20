package ru.stavarachi.service;

import ru.stavarachi.mapper.WeatherMapper;
import ru.stavarachi.model.Weather;

import static ru.stavarachi.utils.RequestUtil.HTTPRequest;

public class RenderService {
    public String renderWeather(String city, String token) {
        String json = HTTPRequest(city, token);
        Weather weather = WeatherMapper.toEntity(json);

        String text = "Город: " + weather.getCity() +
                "\n Температура: " + weather.getTemperature() +
                "\n Влажность: " + weather.getHumidity() +
                "\n Ветер: " + weather.getWindSpeed() +
                "\n Описание: " + weather.getDescription();

        return text;
    }
}
