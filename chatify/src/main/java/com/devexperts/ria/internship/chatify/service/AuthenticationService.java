package com.devexperts.ria.internship.chatify.service;

import com.devexperts.ria.internship.chatify.model.Role;
import com.devexperts.ria.internship.chatify.model.User;
import com.devexperts.ria.internship.chatify.model.dto.UserRequest;
import com.devexperts.ria.internship.chatify.repository.RoleRepository;
import com.devexperts.ria.internship.chatify.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(UserRequest userRequest){
        if(isRequestNotEligible(userRequest)){
            throw new IllegalArgumentException("Username or password cannot be empty or consist of whitespace only");
        }
        if(roleRepository.findByAuthority("USER").isEmpty()){
            roleRepository.save(new Role("USER"));
        }
        Set<Role> authorities = new HashSet<>();
        authorities.add(roleRepository.findByAuthority("USER").get());
        userRepository.save(new User(
                0L,
                userRequest.getUsername(),
                passwordEncoder.encode(userRequest.getPassword()),
                authorities));
        return userRequest.getUsername();
    }

    public String loginUser(UserRequest userRequest){
        return "ok";
    }

    private boolean isRequestNotEligible(UserRequest userRequest){
        return (userRequest.getUsername().isEmpty() ||
                userRequest.getUsername().isBlank() ||
                userRequest.getPassword().isEmpty() ||
                userRequest.getPassword().isBlank());
    }
}
