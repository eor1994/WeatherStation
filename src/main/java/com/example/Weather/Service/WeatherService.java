package com.example.Weather.Service;

import com.example.Weather.Model.Inventory;
import com.example.Weather.Model.WeatherModel;
import com.example.Weather.Repository.InventoryRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherService {
    private final WebClient webClient;
    //private WebClient.Builder webClientBuilder;
    @Autowired
    private InventoryRepository inventoryRepository;

    private static final String WEATHER_API_URL = "https://api.openweathermap.org/data/2.5/weather";
    //private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
    //weather api
    private final String apiKey_weather = "257b4304aeeb76b44b77358c13ccccac";

    //AI Service---------------------------------
    private final String apiKey_AI = "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";

    //service calls template ---------------------------------
    public WeatherService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://api.openweathermap.org/data/2.5/weather").build();
    }

    public WeatherModel getWeather(String city, String country) {
        String response = webClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .queryParam("q", city + "," + country)
                            .queryParam("appid",apiKey_weather )
                            .queryParam("units", "metric")
                            .build())

                    .retrieve()
                    .bodyToMono(String.class)
                    .block();  // For simplicity in examples; avoid in production

        // Parse the response and extract weather data
        JSONObject jsonObject = new JSONObject(response);
        String description = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
        double temperature = jsonObject.getJSONObject("main").getDouble("temp");
        double latitude = jsonObject.getJSONObject("coord").getDouble("lat");
        double longitude = jsonObject.getJSONObject("coord").getDouble("lon");

        return new WeatherModel(city, country, description, temperature, latitude, longitude);
    }

    //inventory database service---------------------------------
    @Autowired
    private InventoryRepository InventoryRepository;

    // Fetch all inventories
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    // Fetch an inventory by ID
    public Optional<Inventory> getInventoryById(@PathVariable String id) {
        return inventoryRepository.findById(id);
    }

    //create a new item ?
    // Add new inventory
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }


    //------------------------------
    // Method to combine data and generate ChatGPT response using WeatherModel data

    //chatgpt service:---------------------------------





    //public String generateChatGPTResponse(String city, String countryCode) {
        // Fetch weather data as WeatherModel
      //  WeatherModel weatherModel = getWeather(city, countryCode);




        // Create prompt for ChatGPT using weather data from WeatherModel
     //   String combinedPrompt = String.format(weatherModel.getCity());

        // Call ChatGPT API

        //return responseText;
   // }



}

