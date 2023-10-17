package com.devexperts.ria.internship.chatify.controller;

import com.devexperts.ria.internship.chatify.model.User;
import com.devexperts.ria.internship.chatify.model.dto.UserRequest;
import com.devexperts.ria.internship.chatify.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRequest userRequest){
        return authenticationService.registerUser(userRequest);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody UserRequest userRequest){
        return authenticationService.loginUser(userRequest);
    }
}
