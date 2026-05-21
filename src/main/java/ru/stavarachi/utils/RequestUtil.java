package ru.stavarachi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestUtil {
    private static final Logger logger = LoggerFactory.getLogger(RequestUtil.class);
    public static String HTTPRequest(String city, String token) {
        try {
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid="+ token + "&units=metric" + "&lang=ru";

            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();

            return responseBody;
        } catch (Exception e) {
            logger.error("Error: ", e);
            return null;
        }
    }
}
