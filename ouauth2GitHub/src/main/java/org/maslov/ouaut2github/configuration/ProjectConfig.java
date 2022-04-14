package org.maslov.ouaut2github.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
//@EnableWebMvc
//@EnableWebSecurity
public class ProjectConfig
        extends WebSecurityConfigurerAdapter {

    private final String clientId;
    private final String clientSecret;

    public ProjectConfig(@Value("${oatuh2.clientid}") String clientId, @Value("${oatuh2.clientsecret}") String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login();
        http.authorizeRequests()
                .anyRequest()
                .authenticated();


    }

    private ClientRegistration clientRegistration() {
        ClientRegistration cr =
                ClientRegistration.withRegistrationId("github")
                        .clientId(clientId)
                        .clientSecret(clientSecret)
                        .scope(new String[]{"read:user"})
                        .authorizationUri(
                                "https://github.com/login/oauth/authorize")
                        .tokenUri("https://github.com/login/oauth/access_token")
                        .userInfoUri("https://api.github.com/user")
                        .userNameAttributeName("id")
                        .clientName("GitHub")
                        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                        //.redirectUriTemplate("{baseUrl}/{action}/oauth2/code/{registrationId}")
                        .redirectUri("{baseUrl}/{action}/oauth2/code/{registrationId}")
                        .build();
        return cr;
    }

    @Bean
    public ClientRegistrationRepository clientRepository() {
        var c = clientRegistration();
        return new InMemoryClientRegistrationRepository(c);
    }
}
