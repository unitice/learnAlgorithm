package com.it.algorithm.controller;

import com.alibaba.fastjson.JSONObject;
import com.it.entity.TestEntityCase;
import com.it.service.TestUserService;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author 君落羽
 */
@RestController
@RequestMapping("test")
public class AlgorithmTestController {

    @PostMapping("test1")
    public String test(){
        return "test";
    }

    private TestUserService testUserService;


    /**
     * set注入
     * @param testUserService
     */
    @Autowired
    public void setTestUserService(TestUserService testUserService){
        this.testUserService = testUserService;
    }

    @Autowired
    @Qualifier("user")
    private UserService userService;

    @Resource(name = "user1")
    private UserService userService1;


    @GetMapping("user")
    public String getUser(){
        return userService.SystemOut();
    }

    @GetMapping("user1")
    public String getUser1(){
        return userService1.SystemOut();
    }

    @PostMapping("test2")
    public String test2(TestEntityCase testEntityCase) throws IOException {
        List<MultipartFile> files = testEntityCase.getFiles();
        MultipartFile multipartFile = files.get(0);
        InputStream inputStream = multipartFile.getInputStream();
        String originalFilename = multipartFile.getOriginalFilename();
        System.out.println(originalFilename);
        System.out.println(inputStream);
        return "success";
    }
}
