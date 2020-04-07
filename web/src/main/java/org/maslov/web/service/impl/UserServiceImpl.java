package org.maslov.web.service.impl;

import org.maslov.web.dao.impl.UserDaoImpl;
import org.maslov.web.entity.User;
import org.maslov.web.service.UserService;
import org.springframework.util.DigestUtils;

public class UserServiceImpl implements UserService {
    @Override
    public String login(User user) {
        UserDaoImpl userDao = new UserDaoImpl();
        User findUser = userDao.findByLogin(user.getLogin());
        if(findUser!=null){
            if(DigestUtils.md5DigestAsHex((user.getPassword()).getBytes()).equals(findUser.getPassword())){
                return "life is beautiful"  + "your Id: " + findUser.getId();
            }
        }
        return "do not give up";
    }

    @Override
    public String registration(User user) {
        UserDaoImpl userDao = new UserDaoImpl();
        User findUser = userDao.findByLogin(user.getLogin());
        if(findUser==null) {
            userDao.save(user);
            return "life is beautiful";
        }
        return "this login is not available";
    }
}
