package com.zengcode.llm;

import dev.langchain4j.model.ollama.OllamaLanguageModel;
import dev.langchain4j.model.output.Response;

public class HelloLLM {
    public static void main(String[] args) {
        OllamaLanguageModel model = OllamaLanguageModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("llama3.2:latest")
                .build();

        Response<String> rawResponse = model.generate("อธิบายหลักการทำงานของ LangChain4j อย่างย่อ");
        String response = rawResponse.content();

        System.out.println("LLM Response : " + response);
    }
}