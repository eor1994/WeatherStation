package com.example.Weather.Controler;

import com.example.Weather.Model.WeatherModel;
import com.example.Weather.Service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;
    //@Value("${weather.api.key}")
    private String apiKey = "257b4304aeeb76b44b77358c13ccccac";

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/api/weather")
    public WeatherModel
    getWeather(@RequestParam(value = "city", defaultValue = "Dublin") String city) {
        return weatherService.getWeather(city, apiKey);
    }

}
