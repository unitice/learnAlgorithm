package com.it.algorithm.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 君落羽
 */
@RestController
public class AlgorithmTestController {

    @PostMapping("test")
    public String test(){
        return "test";
    }
}
