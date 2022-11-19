package org.maslov.hib.app.model.listener;

import jakarta.persistence.PostLoad;
import lombok.extern.slf4j.Slf4j;
import org.maslov.hib.app.model.Message;

@Slf4j
public class MessageListener {

    @PostLoad
    void preloadMessage(Object object) {
      if (object instanceof Message) {
          var message = (Message) object;
          log.info("message.id: " + message.getId());
          log.info("message.test: " + message.getText());
      }
    }
}
