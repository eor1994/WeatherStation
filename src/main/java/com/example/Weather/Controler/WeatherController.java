package com.example.Weather.Controler;

import com.example.Weather.Model.WeatherModel;
import com.example.Weather.Service.ChatGPTService;
import com.example.Weather.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class WeatherController {

    private final WeatherService weatherService;
    //@Value("${weather.api.key}")


    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }



    @GetMapping("/searchWeather")
    public WeatherModel WeatherModel
        //getWeather
    (
            @RequestParam(value = "city") String city,
            @RequestParam(value = "countryCode") String countryCode,
            //country code IRE = Ireland
            Model model) {
        try {
            WeatherModel weatherModel = weatherService.getWeather(city, countryCode);
            model.addAttribute("weather", weatherModel);
        }
        catch (Exception e) {
            model.addAttribute("error", "Could not fetch weather data.");
        }

        return weatherService.getWeather(city, countryCode);
    }
}