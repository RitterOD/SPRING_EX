package org.maslov.htmx.app.model.mapper;

import org.maslov.htmx.app.model.Message;
import org.maslov.htmx.app.model.MessageView;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageMapper {

    public MessageView map(Message msg) {
        return MessageView.builder()
                .id(msg.getId())
                .message(msg.getMessage())
                .build();
    }

    public List<MessageView> map(List<Message> msgs) {
        return  msgs.stream().map(e -> map(e)).collect(Collectors.toList());
    }
}
