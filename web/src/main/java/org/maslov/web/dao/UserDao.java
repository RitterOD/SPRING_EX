package org.maslov.web.dao;
import org.maslov.web.entity.User;

public interface UserDao {
    User findByLogin(String login);
    Boolean save(User user);
}
