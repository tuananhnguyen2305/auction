package com.uet.auction.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String address;
    private String contactNumber;
    private String identityNumber;
}
