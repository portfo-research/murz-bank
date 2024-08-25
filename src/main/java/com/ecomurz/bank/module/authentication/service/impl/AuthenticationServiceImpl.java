package com.ecomurz.bank.module.authentication.service.impl;

import com.ecomurz.bank.module.authentication.request.SignInRequest;
import com.ecomurz.bank.module.authentication.request.SignUpRequest;
import com.ecomurz.bank.module.authentication.response.JwtAuthenticationResponse;
import com.ecomurz.bank.module.authentication.service.AuthenticationService;
import com.ecomurz.bank.module.jwt.service.JwtService;
import com.ecomurz.bank.module.user.entity.Users;
import com.ecomurz.bank.module.user.enums.Role;
import com.ecomurz.bank.module.user.service.UserService;
import com.ecomurz.bank.utils.exception.EmailHasRegisterException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        String email = request.getEmail();
        validateEmailIsUsed(email);
        var user = new Users();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());

        user.setRole(Role.USER);

        userService.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SignInRequest request) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        bCryptPasswordEncoder.encode(request.getPassword());
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        authenticationManager.authenticate(authentication);
        var user = userService.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    private void validateEmailIsUsed(String email) {
        Optional<Users> userOpt = userService.findByEmail(email);
        if (userOpt.isPresent()) {
            throw new EmailHasRegisterException("Email " + email + " sudah terdaftar");
        }
    }
}
