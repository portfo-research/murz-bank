package com.ecomurz.bank.module.user.service;

import com.ecomurz.bank.module.user.entity.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService {
    UserDetailsService userDetailsService();

    Users save(Users user);

    Optional<Users> findByEmail(String email);
}
