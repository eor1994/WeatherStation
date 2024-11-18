package com.example.Weather.Controler;

import com.example.Weather.Model.WeatherModel;
import com.example.Weather.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class WeatherController {

    private final WeatherService weatherService;
    //@Value("${weather.api.key}")
    static WeatherModel weatherModel;


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
            weatherModel = weatherService.getWeather(city, countryCode);
            System.out.println(weatherModel.getCity());
            System.out.println(countryCode);
            System.out.println(weatherModel.getCountry());
            System.out.println(weatherModel.getTemperature());

            model.addAttribute("weather", weatherModel);
        }
        catch (Exception e) {
            model.addAttribute("error", "Could not fetch weather data.");
        }

        return weatherService.getWeather(city, countryCode);
    }

    public static WeatherModel returnWM(){
        return weatherModel;
    }
}