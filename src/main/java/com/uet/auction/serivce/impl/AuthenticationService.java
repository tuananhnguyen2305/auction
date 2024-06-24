package com.uet.auction.serivce.impl;

import com.uet.auction.dto.response.AuthenticationResponse;
import com.uet.auction.entity.User;
import com.uet.auction.repository.IUserRepository;
import com.uet.auction.serivce.IAuthenticationService;
import com.uet.auction.utils.JWTUtilsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService{
    @Autowired
    JWTUtilsHelper jwtUtilsHelper;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    public AuthenticationResponse authenticate(String username, String password) {
        User user = userRepository.findByUsername(username).get();

        boolean authenticated = passwordEncoder.matches(password, user.getPassword());

        if (!authenticated) {
            return AuthenticationResponse.builder()
                    .token(null)
                    .authenticated(false)
                    .build();
        }

        String token = jwtUtilsHelper.generateToken(user);

        return AuthenticationResponse.builder()
                .token(token)
                .authenticated(true)
                .build();
    }


}
