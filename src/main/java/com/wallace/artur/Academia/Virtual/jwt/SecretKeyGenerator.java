package com.wallace.artur.Academia.Virtual.jwt;

import io.jsonwebtoken.Jwts;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class SecretKeyGenerator {

    private SecretKey key;

    public SecretKey getKey() {
        if (key == null) {
            key = Jwts.SIG.HS256.key().build();
        }
        return null;
    }
}
