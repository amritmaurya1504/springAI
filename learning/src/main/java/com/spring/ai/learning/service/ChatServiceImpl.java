package com.spring.ai.learning.service;

import com.spring.ai.learning.enitity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultOptions(OpenAiChatOptions.builder()
                        .model("gpt-3.5-turbo")
                        .temperature(0.3)
                        .maxTokens(1000)
                        .build())
                .build();

        // Default options can also be set at the prompt level, which will override the default options set at the client level.
    }

    @Override
    public List<Tut> chats(String message) {

        /*String prompt = "tell me about virat kohli";*/
        Prompt prompt1 = new Prompt(message);
        // 1. Call the LLM for response
        /*var content = chatClient.prompt()
                .user(prompt)
                .system("As an expert in cricket.")
                .call()
                .content();*/

        /*String content = chatClient.prompt(prompt1)
                .call()
                .chatResponse()
                .getResult().
                getOutput()
                .getText();*/

       /* var content = chatClient.prompt(prompt1)
                .call().chatResponse().getMetadata();

        System.out.println(content);*/

        List<Tut> tut = chatClient.prompt(prompt1)
                .call()
                .entity(new ParameterizedTypeReference<List<Tut>>() {
                });

        return tut;
    }

    @Override
    public String chat(String message) {
        /*Prompt prompt = new Prompt(message, OpenAiChatOptions.builder()
                .model("gpt-3.5-turbo")
                .temperature(0.3)
                .maxTokens(100)
                .build());*/
        Prompt prompt = new Prompt(message);

        // Modify this prompt and add extra instructions to the LLM to get a more specific response.
        String queryStr = "As an expert in coding and programming. Always write programs in java. " +
                "Now reply to the following query: ${query}";

        // Now we use PromptTemplate to create a prompt with the query string and the options.


        var content = chatClient
                .prompt()
                .user(promptUserSpec -> promptUserSpec.text(queryStr).param("query", message))
                .call()
                .content();

        return content;
    }
}
