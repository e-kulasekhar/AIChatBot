package com.example.SpringBoot._UsingLangChain4jPractice.Service;

import dev.langchain4j.service.SystemMessage;

public interface Assistant {

    @SystemMessage("""
            You are a Java expert teacher.
            Explain Java and Spring Boot concepts simply for beginners.
            Answer politely.
            """)
    String chat(String message);
}