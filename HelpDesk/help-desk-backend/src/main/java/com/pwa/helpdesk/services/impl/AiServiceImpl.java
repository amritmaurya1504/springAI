package com.pwa.helpdesk.services.impl;

import com.pwa.helpdesk.services.AiService;
import com.pwa.helpdesk.tools.CurrentSystemTime;
import com.pwa.helpdesk.tools.TicketDatabaseTool;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class AiServiceImpl implements AiService {

    private final ChatClient chatClient;
    private final TicketDatabaseTool ticketDatabaseTool;
    private final CurrentSystemTime currentSystemTime;

    @Value(("classpath:/helpdesk-system.st"))
    private Resource systemPromptResource;

    @Override
    public String getResponseFromAssistant(String query) {
        return chatClient
                .prompt()
                .tools(ticketDatabaseTool, currentSystemTime)
                .system(systemPromptResource)
                .user(query)
                .call()
                .content();
    }
}
