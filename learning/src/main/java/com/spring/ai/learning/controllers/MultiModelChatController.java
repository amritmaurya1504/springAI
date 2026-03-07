/*
package com.spring.ai.learning.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MultiModelChatController {

    private ChatClient openAIChatClient;
    private ChatClient ollamaChatClient;

    */
/*public MultiModelChatController(OpenAiChatModel openAiChatModel,
                                    OllamaChatModel ollamaChatModel) {
        this.openAIChatClient = ChatClient.create(openAiChatModel);
        this.ollamaChatClient = ChatClient.create(ollamaChatModel);
    }*//*


    public MultiModelChatController(@Qualifier("openAIChatClient") ChatClient openAIChatClient,
                                    @Qualifier("ollamaChatClient") ChatClient ollamaChatClient) {
        this.openAIChatClient = openAIChatClient;
        this.ollamaChatClient = ollamaChatClient;
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(
            @RequestParam(value = "q", required = true) String query
    ) {
        String content = openAIChatClient.prompt(query).call().content();// This is where you would handle the response from the chat client
        return ResponseEntity.ok("You asked: " + content);
    }
}
*/
