package org.maslov.reactjwtback.service;

import org.maslov.reactjwtback.model.AppUserDetails;
import org.maslov.reactjwtback.repository.AppUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    public UserDetailsServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByLogin(username).map(u -> new AppUserDetails(u))
                .orElseThrow(() -> new UsernameNotFoundException("not found user with name: " + username));
    }
}
