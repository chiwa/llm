package com.zengcode.llm.controller;

import com.zengcode.llm.agent.FreeAskAgent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ask")
public class FreeAskController {

    private final FreeAskAgent freeAskAgent;

    public FreeAskController(FreeAskAgent freeAskAgent) {
        this.freeAskAgent = freeAskAgent;
    }

    @GetMapping
    public String ask(@RequestParam String question) {
        return freeAskAgent.askAnything(question);
    }
}

