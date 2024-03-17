package com.prokhure.erp.domain.config;

import com.prokhure.erp.domain.ports.spi.UserTrackerPersistencePort;
import com.prokhure.erp.infrastructure.entity.users.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {
    public UserDetailsServiceImpl(UserTrackerPersistencePort userTrackerPersistencePort) {
        this.userTrackerPersistencePort = userTrackerPersistencePort;
    }
    UserTrackerPersistencePort userTrackerPersistencePort;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Authentication> userInfoOptional = userTrackerPersistencePort.findByEmail(username);
        if (userInfoOptional.isPresent()) {
            Authentication userInfo = userInfoOptional.get();
            return User.builder()
                    .username(userInfo.getEmail())
                    .password(userInfo.getPassword())
                    .roles(userInfo.getUserRole())
                    .build();
        } else {
            throw new UsernameNotFoundException("username: " + username + " not found");
        }

    }
}
