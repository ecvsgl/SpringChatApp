package com.devexperts.ria.internship.chatify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class TokenService {

    @Autowired
    private JwtEncoder jwtEncoder;

    @Autowired
    private JwtDecoder jwtDecoder;

    public String generateJwt(Authentication auth){
        String scope = auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));
        System.out.println(scope);
        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .issuer("chatifyBE")
                .issuedAt(Instant.now())
                .subject(auth.getName())
                .claim("roles", scope)
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }
    public Jwt decodeJwt(String token){
        try {
            return jwtDecoder.decode(token);
        } catch (JwtException e){
            throw new RuntimeException("Failed to decode JWT", e);
        }
    }

}
