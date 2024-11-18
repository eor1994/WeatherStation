package com.example.Weather.Controler;

import com.example.Weather.Model.UserRequest;
import com.example.Weather.Service.WeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatgpt")

public class ChatGPTController {

    private final WeatherService chatGPTService;


    public ChatGPTController(WeatherService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }

    @PostMapping("/send")
    public String sendMessageToChatGpt(@RequestBody UserRequest userRequest) {
        return chatGPTService.getChatGptResponse();
    }

}
