package com.config.annot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import  org.springframework.stereotype.Component;

@Component("renderer")
public class TxtMessageRenderer implements MessageRenderer {
    private MessageProvider provider;

    @Autowired
    public TxtMessageRenderer(@Qualifier("provider") MessageProvider provider) {
        this.provider = provider;
    }

    @Override
    public void renderMessage() {
        String message = provider.getMessage();
        System.out.println("Message from provider: "  + message);
    }
}
