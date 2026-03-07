/*
package com.spring.ai.learning.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class TestController {

    // You cannot directly inject ChatClient as it is not a Spring Bean.
    // you can use Builder pattern to create an instance of ChatClient when needed.
    private ChatClient chatClient;

    public TestController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(
            @RequestParam(value = "q", required = true) String query
    ) {
        String content = chatClient.prompt(query).call().content();// This is where you would handle the response from the chat client
        return ResponseEntity.ok("You asked: " + content);
    }

}
*/
