package org.maslov.web.service;

import org.maslov.web.entity.User;

public interface UserService {
    public String login(User user);
    public String registration(User user);
}
