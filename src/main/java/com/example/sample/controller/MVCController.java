package com.example.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author renzhiyong
 * @Date 2017/9/12 11:09
 */
@Controller
public class MVCController {

    @RequestMapping("/mvc/index")
    public String index() {
        return "index";
    }
}
