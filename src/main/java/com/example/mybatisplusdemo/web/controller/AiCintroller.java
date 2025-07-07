package com.example.mybatisplusdemo.web.controller;

import com.example.mybatisplusdemo.assistant.Assistant;
import com.example.mybatisplusdemo.common.Result;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class AiCintroller {
    @Autowired
    private ChatLanguageModel chatLanguageModel;
    @Autowired
    private Assistant assistant;

    @GetMapping("chat1")
    public Result chat(String msg) {
        String chat = assistant.chat(msg);
        return Result.success(chat);
    }
}
