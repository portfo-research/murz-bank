package com.ecomurz.bank.module.authentication.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
