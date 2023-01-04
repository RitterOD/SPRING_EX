package org.maslov.template.auth;

import org.maslov.template.auth.model.SecurityUser;
import org.maslov.template.auth.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

public interface AuthService {
    default SecurityUser getUser() {
        return (SecurityUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
