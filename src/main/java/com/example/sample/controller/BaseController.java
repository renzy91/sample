package com.example.sample.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description:
 * @Author renzhiyong
 * @Date 2017/9/5 14:56
 */
@RestController
@RequestMapping("/base")
@Api(value="基础控制器", description = "基础控制器", position = 1, hidden = false)
public class BaseController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(value = "基础接口" ,notes = "基础接口1")
    public String base() {
        return "Hello";
    }

}
