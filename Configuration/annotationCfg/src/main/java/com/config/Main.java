package com.config;
import com.config.annot.TxtMessageRenderer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        System.out.println("Spring annotation configuration example!");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        TxtMessageRenderer rnd = (TxtMessageRenderer) context.getBean("renderer");
        rnd.renderMessage();
    }
}
