package com.example.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author renzhiyong
 * @Date 2017/9/5 14:56
 */
@RestController
public class BaseController {
    @RequestMapping("/")
    public String base() {
        return "Hello";
    }
}
