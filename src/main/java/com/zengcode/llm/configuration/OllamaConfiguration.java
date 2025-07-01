package com.zengcode.llm.configuration;

import com.zengcode.llm.agent.DevOpsAgent;
import com.zengcode.llm.agent.FreeAskAgent;
import com.zengcode.llm.agent.JavaAgent;
import com.zengcode.llm.agent.SpringAgent;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(OllamaProperties.class)
public class OllamaConfiguration {

    @Bean
    public FreeAskAgent freeAskAgent(OllamaProperties properties) {
        ChatLanguageModel model = OllamaChatModel.builder()
                .baseUrl(properties.getBaseUrl())
                .modelName(properties.getModelName())
                .build();

        return AiServices.create(FreeAskAgent.class, model);
    }

    @Bean
    public JavaAgent javaAgent(OllamaProperties properties) {
        ChatLanguageModel model = OllamaChatModel.builder()
                .baseUrl(properties.getBaseUrl())
                .modelName(properties.getModelName())
                .build();
        return AiServices.create(JavaAgent.class, model);
    }

    @Bean
    public SpringAgent springAgent(OllamaProperties properties) {
        ChatLanguageModel model = OllamaChatModel.builder()
                .baseUrl(properties.getBaseUrl())
                .modelName(properties.getModelName())
                .build();
        return AiServices.create(SpringAgent.class, model);
    }

    @Bean
    public DevOpsAgent devOpsAgent(OllamaProperties properties) {
        ChatLanguageModel model = OllamaChatModel.builder()
                .baseUrl(properties.getBaseUrl())
                .modelName(properties.getModelName())
                .build();
        return AiServices.create(DevOpsAgent.class, model);
    }
}