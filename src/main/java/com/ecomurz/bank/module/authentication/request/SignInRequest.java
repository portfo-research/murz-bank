package com.ecomurz.bank.module.authentication.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class SignInRequest {
    private String email;
    private String password;
}
