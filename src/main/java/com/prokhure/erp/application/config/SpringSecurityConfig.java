package com.prokhure.erp.application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfig {
    @Autowired
    JwtAuthFilter jwtAuthFilter;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers(getSwaggerRequestMatcher()).permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    private RequestMatcher[] getSwaggerRequestMatcher() {
        return new RequestMatcher[]{
                AntPathRequestMatcher.antMatcher("/swagger-ui/**"),
                AntPathRequestMatcher.antMatcher("/v3/api-docs/swagger-config"),
                AntPathRequestMatcher.antMatcher("/*.yaml"),
                AntPathRequestMatcher.antMatcher("/actuator/**"),
                AntPathRequestMatcher.antMatcher("/*/*.yaml"),
                AntPathRequestMatcher.antMatcher(HttpMethod.POST,
                        "/user/registration"),
                AntPathRequestMatcher.antMatcher(HttpMethod.POST,
                        "/user/login"),
                AntPathRequestMatcher.antMatcher(HttpMethod.POST,
                        "/user/password/reset/email"),
                AntPathRequestMatcher.antMatcher(HttpMethod.POST,
                        "/user/token"),
                AntPathRequestMatcher.antMatcher(HttpMethod.GET,
                        "/bank"),
                AntPathRequestMatcher.antMatcher(HttpMethod.POST,
                        "/category"),
                AntPathRequestMatcher.antMatcher(HttpMethod.PATCH,
                        "/category"),
                AntPathRequestMatcher.antMatcher(HttpMethod.GET,
                        "/category"),
                AntPathRequestMatcher.antMatcher(HttpMethod.GET,
                        "/category/**"),
                AntPathRequestMatcher.antMatcher(HttpMethod.PATCH,
                        "/category/**")
        };
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
