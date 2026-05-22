package com.example.SpringBoot._UsingLangChain4jPractice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot._UsingLangChain4jPractice.Service.Assistant;

@RestController
public class ChatController {

    private final Assistant assistant;

    public ChatController(Assistant assistant) {
        this.assistant = assistant;
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message) {

        return assistant.chat(message);
    }
}