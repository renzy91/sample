package com.example.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @Description:
 * @Author renzhiyong
 * @Date 2017/9/12 18:21
 */
@RestController
public class I18nController {
    @Autowired
    private ReloadableResourceBundleMessageSource messageSource ;

    @RequestMapping("/i18n")
    public String i18n() {
        String message = messageSource.getMessage("error.0", null, Locale.CHINA);
        System.out.println(message);
        return message;
    }
}
