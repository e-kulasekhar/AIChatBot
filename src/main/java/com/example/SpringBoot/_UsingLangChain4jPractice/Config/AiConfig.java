package com.example.SpringBoot._UsingLangChain4jPractice.Config;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.SpringBoot._UsingLangChain4jPractice.Service.Assistant;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

@Configuration
public class AiConfig {

    // MULTIPLE API KEYS

    private final List<String> apiKeys = Arrays.asList(

            System.getenv("GROQ_API_KEY_1"),

            System.getenv("GROQ_API_KEY_2"),

            System.getenv("GROQ_API_KEY_3")
    );

    // CURRENT KEY INDEX

    private final AtomicInteger currentKeyIndex =
            new AtomicInteger(0);

    @Bean
    public OpenAiChatModel chatModel() {

        String currentApiKey =
                apiKeys.get(currentKeyIndex.get());

        return OpenAiChatModel.builder()

                .baseUrl("https://api.groq.com/openai/v1")

                .apiKey(currentApiKey)

                .modelName("llama-3.1-8b-instant")

                .build();
    }

    @Bean
    public Assistant assistant(OpenAiChatModel model) {

        return AiServices.builder(Assistant.class)

                .chatLanguageModel(model)

                .chatMemory(
                        MessageWindowChatMemory
                                .withMaxMessages(20)
                )

                .build();
    }
}