package com.ecomurz.bank.module.authentication.service;

import com.ecomurz.bank.module.authentication.request.SignInRequest;
import com.ecomurz.bank.module.authentication.request.SignUpRequest;
import com.ecomurz.bank.module.authentication.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}
