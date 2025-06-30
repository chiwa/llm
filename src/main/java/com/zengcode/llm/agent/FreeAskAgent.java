package com.zengcode.llm.agent;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface FreeAskAgent {

    @SystemMessage("You are a Senior Java Developer who specializes in Spring Boot. Be helpful and concise.")
    @UserMessage("What are the best practices for using {question} in Spring Boot?")
    String askAnything(String question);
}