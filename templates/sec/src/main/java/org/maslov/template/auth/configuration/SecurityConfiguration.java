package org.maslov.template.auth.configuration;

import org.maslov.template.auth.component.JwtTokenAuthenticationFilter;
import org.maslov.template.auth.service.JWTUtils;
import org.maslov.template.auth.service.UserDetailsServiceSpringData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.ExceptionTranslationFilter;

@Configuration
public class SecurityConfiguration {

  private final UserDetailsServiceSpringData userDetailsServiceSpringData;
  private final JWTUtils jwtUtils;


  public SecurityConfiguration(UserDetailsServiceSpringData userDetailsServiceSpringData, JWTUtils jwtUtils) {
    this.userDetailsServiceSpringData = userDetailsServiceSpringData;
    this.jwtUtils = jwtUtils;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }




  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
          throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
            .csrf().disable()
            .httpBasic().disable()
            .formLogin().disable()
            .addFilterAfter(new JwtTokenAuthenticationFilter(userDetailsServiceSpringData, jwtUtils), ExceptionTranslationFilter.class)
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET, RestURL.API_V1_HOME)
                    .permitAll())
            .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST, RestURL.API_V1_AUTH)
                    .permitAll())
            .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.GET,
                            RestURL.API_V1_DIAG,
                            RestURL.API_V1_DIAG + "/**",
                            RestURL.API_V1_DIAG_ACCOUNTS,
                            RestURL.API_V1_DIAG_ACCOUNTS + "/**",
                            RestURL.API_V1_DIAG_WORKSPACES,
                            RestURL.API_V1_DIAG_WORKSPACES + "/**")
                    .hasAnyRole("USER", "ADMIN"))
            .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST,
                            RestURL.API_V1_DIAG,
                            RestURL.API_V1_DIAG + "/**",
                            RestURL.API_V1_DIAG_ACCOUNTS,
                            RestURL.API_V1_DIAG_WORKSPACES)
                    .hasAnyRole("USER", "ADMIN"))
            .authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST, RestURL.API_V1_AUTH_CREATE)
                  .hasAnyRole("ADMIN"));
    return httpSecurity.build();
  }


}
