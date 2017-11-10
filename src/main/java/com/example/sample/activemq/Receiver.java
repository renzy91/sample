package com.example.sample.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author renzhiyong
 * @Date 2017/10/13 16:48
 */
@Component
public class Receiver {
    @JmsListener(destination = "test")
    public void receiveMessage(String msg) {
        System.out.println("收到消息:"+msg);
    }
}
