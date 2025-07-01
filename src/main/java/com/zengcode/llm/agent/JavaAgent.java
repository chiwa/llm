package com.zengcode.llm.agent;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface JavaAgent {

    @SystemMessage("You are a helpful and detailed expert in Java.")
    @UserMessage("Please explain in detail: {question}")
    String ask(String question);
}