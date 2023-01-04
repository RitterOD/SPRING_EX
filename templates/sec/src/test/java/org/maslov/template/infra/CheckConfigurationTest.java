package org.maslov.template.infra;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.maslov.template.TestConstants;
import org.maslov.template.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
public class CheckConfigurationTest {
    @Autowired
    public UserService userService;

    @Autowired
    public DataSource dataSource;

    @Test
    void checkAdminCreated() {
        var userOpt = userService.findByLogin(TestConstants.ADMIN_NAME);
        Assertions.assertTrue(userOpt.isPresent());
        Assertions.assertEquals(TestConstants.ADMIN_NAME, userOpt.get().getUsername());
    }

    @Test
    void checkDatasourceHasRightConfiguration() {
        String url = ((HikariDataSource) dataSource).getJdbcUrl();
        String username = ((HikariDataSource) dataSource).getUsername();
        String password = ((HikariDataSource) dataSource).getPassword();
        Assertions.assertEquals(TestConstants.DATASOURCE_URL, url);
        Assertions.assertEquals(TestConstants.DATASOURCE_USERNAME, username);
        Assertions.assertEquals(TestConstants.DATASOURCE_PASSWORD, password);
    }
}
