package com.example.submissiontask.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtils {

    private final String SECRET = "mysecret";

    public String generateToken(String username){

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis()+ 30000))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }


}
