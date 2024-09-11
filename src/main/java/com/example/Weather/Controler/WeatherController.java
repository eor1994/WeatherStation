package com.example.Weather.Controler;

import com.example.Weather.Model.WeatherModel;
import com.example.Weather.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping("/api")
public class WeatherController {

    private final WeatherService weatherService;
    //@Value("${weather.api.key}")
    private String apiKey = "257b4304aeeb76b44b77358c13ccccac";

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String home() {
        return "index";//returns the index.html template
    }

    @GetMapping("/searchWeather")
    public String WeatherModel
        //getWeather
    (
            @RequestParam(value = "city") String city,
            @RequestParam(value = "countryCode") String countryCode,
            //country code IRE = Ireland
            Model model) {
        try {
            WeatherModel weatherModel = weatherService.getWeather(city, countryCode, apiKey);
            model.addAttribute("weather", weatherModel);
        }
        catch (Exception e) {
            model.addAttribute("error", "Could not fetch weather data.");
        }

        return "index";
    }
}