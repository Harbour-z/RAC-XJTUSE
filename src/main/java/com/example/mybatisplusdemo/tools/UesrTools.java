package com.example.mybatisplusdemo.tools;


import com.example.mybatisplusdemo.service.IUserInfoService;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UesrTools {

    @Autowired
    private IUserInfoService userInfoService;

    @Tool("根据id删除数据库的用户")
    public boolean removeById(Long id){
        return  userInfoService.removeById(id);
    }

}
