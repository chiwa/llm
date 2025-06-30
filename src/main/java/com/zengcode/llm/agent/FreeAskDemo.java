package com.zengcode.llm.agent;

import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;

public class FreeAskDemo {
    public static void main(String[] args) {

        ChatLanguageModel model = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("llama3.2:latest")
                .build();

        FreeAskAgent agent = AiServices.create(FreeAskAgent.class, model);

        String answer = agent.askAnything("Spring Boot คืออะไร?");
        System.out.println("🧠 AI Answer: " + answer);
    }
}
