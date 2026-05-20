package ru.stavarachi.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.stavarachi.model.Weather;

public class WeatherMapper {
    public static Weather toEntity(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(json);

            Weather weather = new Weather();

            weather.setCity(jsonNode.get("name").asText());

            weather.setTemperature(jsonNode.get("main").get("temp").asDouble());

            weather.setHumidity(jsonNode.get("main").get("humidity").asInt());

            weather.setWindSpeed(jsonNode.get("wind").get("speed").asDouble());

            weather.setDescription(jsonNode.get("weather").get(0).get("description").asText());

            return weather;
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
