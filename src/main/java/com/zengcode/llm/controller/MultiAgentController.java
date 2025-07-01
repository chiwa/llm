package com.zengcode.llm.controller;

import com.zengcode.llm.agent.DevOpsAgent;
import com.zengcode.llm.agent.JavaAgent;
import com.zengcode.llm.agent.SpringAgent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/ask")
public class MultiAgentController {

    private final JavaAgent javaAgent;
    private final SpringAgent springAgent;
    private final DevOpsAgent devOpsAgent;

    public MultiAgentController(JavaAgent javaAgent, SpringAgent springAgent, DevOpsAgent devOpsAgent) {
        this.javaAgent = javaAgent;
        this.springAgent = springAgent;
        this.devOpsAgent = devOpsAgent;
    }

    @GetMapping
    public String ask(@RequestParam String role, @RequestParam String question) {
        return switch (role.toLowerCase()) {
            case "java" -> javaAgent.ask(question);
            case "spring" -> springAgent.ask(question);
            case "devops" -> devOpsAgent.ask(question);
            default -> "Unknown role: " + role;
        };
    }
}
