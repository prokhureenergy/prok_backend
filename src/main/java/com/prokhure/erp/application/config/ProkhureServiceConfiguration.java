package com.prokhure.erp.application.config;

import com.prokhure.erp.domain.config.UserDetailsServiceImpl;
import com.prokhure.erp.domain.ports.api.UserServicePort;
import com.prokhure.erp.domain.ports.spi.UserTrackerPersistencePort;
import com.prokhure.erp.domain.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ProkhureServiceConfiguration {
    @Bean
    public UserServicePort userServicePort (
            UserTrackerPersistencePort userTrackerPersistencePort,
            PasswordEncoder passwordEncoder
    ){
        return new UserServiceImpl(userTrackerPersistencePort,passwordEncoder);
    }

    @Bean
    public UserDetailsService userDetailsService(
            UserTrackerPersistencePort userTrackerPersistencePort
    ){
        return new UserDetailsServiceImpl(userTrackerPersistencePort);
    }

}
