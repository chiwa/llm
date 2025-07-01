package com.zengcode.llm.agent;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface DevOpsAgent {

    @SystemMessage("You are a DevOps Advisor. Help solve deployment, CI/CD, and infrastructure problems.")
    @UserMessage("{question}")
    String ask(String question);
}