package org.maslov.template.auth.service;


import org.maslov.template.auth.model.SecurityUser;
import org.maslov.template.auth.model.User;
import org.maslov.template.auth.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceSpringData implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceSpringData(UserRepository securityUserRepository) {
        this.userRepository = securityUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> rv = userRepository.findByUsername(s);
        if (rv.isEmpty()) {
            throw new UsernameNotFoundException("Can't find " + User.class.getCanonicalName()
                    + "with username " + s);
        }
        return new SecurityUser(rv.get());
    }
}
