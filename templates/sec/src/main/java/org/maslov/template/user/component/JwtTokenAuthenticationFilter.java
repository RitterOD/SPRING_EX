package org.maslov.template.user.component;

import com.auth0.jwt.exceptions.JWTVerificationException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.maslov.template.user.service.JWTUtils;
import org.maslov.template.user.service.UserDetailsServiceSpringData;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;

public class JwtTokenAuthenticationFilter extends GenericFilter {

    private final UserDetailsServiceSpringData userDetailsServiceSpringData;
    private final JWTUtils jwtUtils;

    public JwtTokenAuthenticationFilter(UserDetailsServiceSpringData userDetailsServiceSpringData, JWTUtils jwtUtils) {
        this.userDetailsServiceSpringData = userDetailsServiceSpringData;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String authHeader = request.getHeader("Authorization");
        if(authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")){
            String jwt = authHeader.substring(7);
            if(jwt == null || jwt.isBlank()){
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token in Bearer Header");
            }else {
                try {
                    String login = jwtUtils.validateTokenAndRetrieveSubject(jwt);
                    UserDetails userDetails = userDetailsServiceSpringData.loadUserByUsername(login);
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(login, userDetails.getPassword(), userDetails.getAuthorities());
                    if (SecurityContextHolder.getContext().getAuthentication() == null) {
                        SecurityContextHolder.getContext().setAuthentication(authToken);
                    }
                }catch(JWTVerificationException exc){
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token");
                }
            }

        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
