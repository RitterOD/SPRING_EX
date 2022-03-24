package org.maslov.configuration;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration
//@EnableWebSecurity
public class SecurityConfiguration /*extends WebSecurityConfigurerAdapter*/ {
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        var userDetailsService = new InMemoryUserDetailsManager();
//        var user = User.withUsername("John").password("12345").authorities("read").build();
//        userDetailsService.createUser(user);
//        return userDetailsService;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.httpBasic(c -> {
////            c.realmName("OTHER");
////            c.authenticationEntryPoint(new CustomEntryPoint());
////        });
//        http.cors().and().csrf().disable();
//        http.authorizeRequests().antMatchers("/*", "/*/*", "/*/*/*", "/user/add", "/hello").permitAll();
//    }
}
