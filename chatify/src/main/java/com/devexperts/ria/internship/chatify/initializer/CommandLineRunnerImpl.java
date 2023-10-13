package com.devexperts.ria.internship.chatify.initializer;

import com.devexperts.ria.internship.chatify.model.Role;
import com.devexperts.ria.internship.chatify.model.User;
import com.devexperts.ria.internship.chatify.repository.MessageRepository;
import com.devexperts.ria.internship.chatify.repository.RoleRepository;
import com.devexperts.ria.internship.chatify.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public CommandLineRunnerImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if(roleRepository.count()==0){
            roleRepository.save(new Role("USER"));
        }
        if(userRepository.count()==0){
            Set<Role> standardAuthorities = new HashSet<>();
            standardAuthorities.add(roleRepository.findByAuthority("USER").get());

            userRepository.save(new User(
                    "user1",
                    passwordEncoder.encode("user1"),
                    standardAuthorities
            ));

            userRepository.save(new User(
                    "user2",
                    passwordEncoder.encode("user2"),
                    standardAuthorities
            ));
        }
    }
}
