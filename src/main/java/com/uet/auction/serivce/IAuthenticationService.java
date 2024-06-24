package com.uet.auction.serivce;

import com.uet.auction.dto.response.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Value;

public interface IAuthenticationService {
    AuthenticationResponse authenticate(String username, String password);
}
