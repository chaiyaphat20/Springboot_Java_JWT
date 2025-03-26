package com.example.springsecurity.services;

import com.example.springsecurity.dto.SignUpRequest;
import com.example.springsecurity.entities.User;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);
}
