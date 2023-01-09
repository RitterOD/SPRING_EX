package com.config.xml;

public class TxtMessageRenderer implements MessageRenderer {
    private MessageProvider provider;

    public TxtMessageRenderer(MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public void renderMessage() {
        String message = provider.getMessage();
        System.out.println("Message from provider: "  + message);
    }
}
