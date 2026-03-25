package com.pwa.helpdesk.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class CurrentSystemTime {

    @Tool(description = "This tools helps to get current system time")
    public String getCurrentSystemTime(){
        return String.valueOf(System.currentTimeMillis());
    }

}
