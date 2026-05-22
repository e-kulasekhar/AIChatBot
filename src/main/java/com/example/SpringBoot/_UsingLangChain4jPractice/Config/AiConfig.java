package com.example.SpringBoot._UsingLangChain4jPractice.Config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.SpringBoot._UsingLangChain4jPractice.Service.Assistant;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

@Configuration
public class AiConfig {

    @Value("${groq.api.key}")
    private String apiKey;

    @Bean
    public OpenAiChatModel chatModel() {

        return OpenAiChatModel.builder()
                .baseUrl("https://api.groq.com/openai/v1")
                .apiKey(apiKey)
                .modelName("llama-3.3-70b-versatile")
                .build();
    }

    @Bean
    public Assistant assistant(OpenAiChatModel model) {

        return AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(20))
                .build();
    }
}