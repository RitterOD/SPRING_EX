package org.maslov.web.dao.impl;
import org.maslov.web.ConnectionManager;
import org.maslov.web.dao.UserDao;
import org.maslov.web.entity.User;
import org.springframework.util.DigestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private ConnectionManager connectionManager;
    private Connection connection;

    public UserDaoImpl() {

    }

    @Override
    public User findByLogin(String login) {
        User user = null;
        connectionManager = new ConnectionManager();
        connection = connectionManager.getConnection();
        if (connection != null) {
            try {
                PreparedStatement pr = connection.prepareStatement("SELECT * FROM DATABASE.User where LOGIN=?");
                pr.setString(1, login);
                ResultSet resultSet = pr.executeQuery();//return sql result
                if (resultSet.next()) {
                    user = new User();
                    user.setId(resultSet.getInt("ID"));
                    user.setName(resultSet.getString("NAME"));
                    user.setSurname(resultSet.getString("SURNAME"));
                    user.setLogin(login);
                    user.setPassword(resultSet.getString("PASSWORD"));
                    return user;
                }
                pr.close();
                connection.close();
            }
            catch (Exception e){
                System.out.println(e.getStackTrace());
            }
        }
        return user;
    }

    @Override
    public Boolean save(User user) {
        connectionManager = new ConnectionManager();
        connection = connectionManager.getConnection();
        if (connection != null) {
            try {
                PreparedStatement pr = connection.prepareStatement("insert into DATABASE.USER (NAME,SURNAME,LOGIN,PASSWORD) values (?,?,?,?)");
                pr.setString(1,user.getName());
                pr.setString(2,user.getSurname());
                pr.setString(3,user.getLogin());
                pr.setString(4, DigestUtils.md5DigestAsHex((user.getPassword()).getBytes()));
                pr.executeUpdate();
                pr.close();
                connection.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

 }