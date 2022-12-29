package org.maslov.template.user.configuration;

import org.maslov.template.user.component.JwtTokenAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.ExceptionTranslationFilter;

@Configuration
public class SecurityConfiguration {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
            .csrf().disable()
            .httpBasic().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET, RestURL.API_V1_HOME)
                    .permitAll())
            .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST, RestURL.API_V1_AUTH)
                    .permitAll())
            .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST, RestURL.API_V1_DIAG)
                    .hasAnyRole("USER", "ADMIN"))
            .addFilterAfter(new JwtTokenAuthenticationFilter(), ExceptionTranslationFilter.class);

    return httpSecurity.build();
  }


}
