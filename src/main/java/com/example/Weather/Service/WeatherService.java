package com.example.Weather.Service;

import com.example.Weather.Model.WeatherModel;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {

    private final WebClient webClient;

    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://api.openweathermap.org/data/2.5/weather").build();
    }

    public WeatherModel getWeather(String city, String apiKey) {
        String response = webClient.get()
                .uri(uriBuilder -> uriBuilder.queryParam("q", city)
                                             .queryParam("appid", apiKey)
                                             .queryParam("units", "metric")
                                             .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();  // For simplicity in examples; avoid in production

        // Parse the response and extract weather data
        JSONObject jsonObject = new JSONObject(response);
        String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
        double temperature = jsonObject.getJSONObject("main").getDouble("temp");

        return new WeatherModel(city, description, temperature);
    }
}
