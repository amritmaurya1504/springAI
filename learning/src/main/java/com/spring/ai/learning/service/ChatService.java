package com.spring.ai.learning.service;

import com.spring.ai.learning.enitity.Tut;

import java.util.List;

public interface ChatService {
    List<Tut> chats(String message);
    String chat(String message);
}
