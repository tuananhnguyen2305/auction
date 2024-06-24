package com.uet.auction.security;

import com.uet.auction.entity.enums.RoleName;
import com.uet.auction.utils.JWTUtilsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
public class CustomFilterSecurity {
    public final String[] PUBLIC_ENDPOINT = {"/auth/**"};
    public final String[] ADMIN_ENDPOINT = {"/user", "/user/employee"};
    public final String[] EMPLOYEE_ENDPOINT = {"/auction/{id}"};
    public final String[] USER_ENDPOINT = {"/user-auction/**", "/bidding/**"};
    @Autowired
    CustomUserDetailService customUserDetailService;

    @Autowired
    CustomJWTFilter customJWTFilter;

    @Autowired
    JWTUtilsHelper jwtUtilsHelper;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity security) throws Exception{
        AuthenticationManagerBuilder authenticationManagerBuilder = security.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.disable())
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, PUBLIC_ENDPOINT).permitAll()
                        .requestMatchers(ADMIN_ENDPOINT).hasAuthority(RoleName.ADMIN.getRole())
                        .requestMatchers(EMPLOYEE_ENDPOINT).hasAuthority(RoleName.EMPLOYEE.getRole())
                        .requestMatchers(USER_ENDPOINT).hasAuthority(RoleName.USER.getRole())
                        .requestMatchers(HttpMethod.POST, "/license", "/auction").hasAuthority(RoleName.USER.getRole())
                        .anyRequest().authenticated()
                );
        security.oauth2ResourceServer(oath2 -> oath2
                .jwt(jwtConfigurer -> jwtConfigurer
                        .decoder(jwtUtilsHelper.jwtDecoder())
                        .jwtAuthenticationConverter(jwtUtilsHelper.jwtAuthenticationConverter())));
        security.addFilterBefore(customJWTFilter, UsernamePasswordAuthenticationFilter.class);
        return security.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
