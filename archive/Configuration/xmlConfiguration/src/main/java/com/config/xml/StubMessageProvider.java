package com.config.xml;

public class StubMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Stub message!";
    }
}
