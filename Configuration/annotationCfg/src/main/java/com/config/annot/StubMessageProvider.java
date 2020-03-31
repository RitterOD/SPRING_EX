package com.config.annot;

import  org.springframework.stereotype.Component;

@Component("provider")
public class StubMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Stub message!";
    }
}
