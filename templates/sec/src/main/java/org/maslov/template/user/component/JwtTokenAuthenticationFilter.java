package org.maslov.template.user.component;

import jakarta.servlet.*;

import java.io.IOException;

public class JwtTokenAuthenticationFilter extends GenericFilter {

    public JwtTokenAuthenticationFilter() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
