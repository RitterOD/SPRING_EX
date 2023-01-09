package com.config;

import com.config.xml.TxtMessageRenderer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("SPRING XML CONFIGURATION EXAMPLE");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        TxtMessageRenderer tmr = (TxtMessageRenderer) context.getBean("messageRenderer");
        tmr.renderMessage();
        context.close();
    }
}
