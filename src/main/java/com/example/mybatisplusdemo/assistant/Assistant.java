package com.example.mybatisplusdemo.assistant;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

@AiService(tools = "userTools")
public interface Assistant {
    @SystemMessage("你是一个资深的老中医，请用专业的词汇回答问题")
    String chat(@UserMessage String msg);
}
