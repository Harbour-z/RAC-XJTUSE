package com.example.mybatisplusdemo.web.controller;


import com.example.mybatisplusdemo.common.Result;
import com.example.mybatisplusdemo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("api/file")
public class FilesController {

    @Autowired
    private FileService fileService;

    @PostMapping("upload")
    public Result upload(MultipartFile file) throws IOException {
        Map upload =  fileService.upload(file);
        return Result.success(upload);
    }
}
