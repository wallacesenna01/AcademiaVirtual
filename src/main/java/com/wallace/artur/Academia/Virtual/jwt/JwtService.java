package com.wallace.artur.Academia.Virtual.jwt;

import com.wallace.artur.Academia.Virtual.AcessToken;
import com.wallace.artur.Academia.Virtual.User.User;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Autowired
    private SecretKeyGenerator keyGenerator;

    public AcessToken generateToken(User user) {

        var key = keyGenerator.getKey();
        var expiration = expirationDate();
        var claims = generateTokenClaims(user);

         String token  =  Jwts.builder()
                .signWith(key)
                .subject(user.getEmail())
                .expiration(expiration)
                .claims(claims)
                .compact();

        return new AcessToken(token);
    }

    public Date expirationDate() {
        var expirationMinutes = 60;
        LocalDateTime now = LocalDateTime.now().plusMinutes(expirationMinutes);
        return Date.from(now.atZone(ZoneId.systemDefault()).toInstant());

    }

    private Map<String, Object> generateTokenClaims(User user ) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("name", user.getName());
        return claims;
    }

}
