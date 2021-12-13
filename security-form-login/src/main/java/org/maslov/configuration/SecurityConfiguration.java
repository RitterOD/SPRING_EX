package org.maslov.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final CustomAuthSuccessHandler customAuthSuccessHandler;
    private final CustomAuthFailHandler customAuthFailHandler;

    public SecurityConfiguration(CustomAuthSuccessHandler customAuthSuccessHandler, CustomAuthFailHandler customAuthFailHandler) {
        this.customAuthSuccessHandler = customAuthSuccessHandler;
        this.customAuthFailHandler = customAuthFailHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().successHandler(customAuthSuccessHandler)
                .failureHandler(customAuthFailHandler).and()
                .httpBasic();
        http.authorizeRequests().anyRequest().authenticated();
    }
}
