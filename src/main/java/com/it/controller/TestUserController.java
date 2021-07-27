package com.it.controller;

import com.it.entity.TestUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author feather
 * @Date 2021/7/27
 */
@Controller
public class TestUserController {

    @PostMapping("/update/file")
    public void updateFile(TestUser testUser){

        MultipartFile file1 = testUser.getFile1();
        MultipartFile file2 = testUser.getFile2();
        MultipartFile file3 = testUser.getFile3();
        System.out.println(file1.getName());
        System.out.println(file1.getOriginalFilename());
    }

}
