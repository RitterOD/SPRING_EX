package org.maslov.simpleDAL;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
    private Properties property;

    public ConnectionManager() {
        try {
            FileInputStream fis;
            property = new Properties();
            fis = new FileInputStream("src/main/resources/application.properties");
            property.load(fis);
            fis.close();
        }
        catch(IOException e) {
            System.out.println(e.getStackTrace());
        }
    }

    //ConnectionManager
    public Connection getConnection() {
        Connection connection = null;
        try {
            String userName = property.getProperty("spring.datasource.username");
            String password = "1";
            /**@todo Fix stub password*/
            //        property.getProperty("spring.datasource.password");
            connection = DriverManager.getConnection(property.getProperty("spring.datasource.url"),
                    userName ,
                    password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
