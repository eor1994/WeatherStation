package com.example.Weather.Controler;
import com.example.Weather.Model.UserRequest;
import com.example.Weather.Service.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatgpt")

public class ChatGPTController {

    private final ChatGPTService chatGPTService;


    public ChatGPTController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }

    @PostMapping("/send")
    public String sendMessageToChatGpt(@RequestBody UserRequest userRequest) {
        return chatGPTService.getChatGptResponse(userRequest.getMessage());
    }
}
