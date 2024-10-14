package com.example.Weather.Service;
//created this java class here for chatpht is
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.io.IOException;

@Service
public class ChatGPTService {
    private final WebClient webClient;
    private String apiKey = "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";


    public ChatGPTService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1").build();
    }

    public String getChatGptResponse(String userMessage) {
        String requestBody = "{\n" +
                "  \"model\": \"gpt-3.5-turbo\",\n" +
                "  \"messages\": [\n" +
                "    {\"role\": \"system\", \"content\": \"You are a helpful assistant.\"},\n" +
                "    {\"role\": \"user\", \"content\": \"" + userMessage + "\"}\n" +
                "  ]\n" +
                "}";

        // Making the API call
        Mono<String> responseMono = webClient.post()
                .uri("/chat/completions")
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class);

        // Block to get the result synchronously
        return responseMono.block();
    }
}

