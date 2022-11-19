package org.maslov.hib.app.model.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.hibernate.CallbackException;
import org.hibernate.Interceptor;
import org.hibernate.type.Type;
import org.maslov.hib.app.model.Message;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Slf4j
@Component
public class HibernateInterceptor implements Interceptor, Serializable {


    // FIXME Return value
    @Override
    public boolean onLoad(Object entity, Object id, Object[] state, String[] propertyNames, Type[] types)
            throws CallbackException {
        log.info("In hibernate interceptor");
        if (entity instanceof Message) {
            var message = (Message) entity;
            log.info("message.id: " + message.getId());
            log.info("message.test: " + message.getText());
        } else {
            log.error("Unsupported type of entity: " + entity.getClass().getSimpleName());
        }
        return false;
    }

}
