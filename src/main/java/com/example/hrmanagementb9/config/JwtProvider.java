package com.example.hrmanagementb9.config;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;

@Component

public class JwtProvider { // maqsad : tokenlar bilan ishlash


    private final String secretKey = "Unicorn B9";

    private final long experation = 1000 * 60 * 60 * 24; // 1kun

    public String generateToken(String username) {

        try {
            String token = Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + experation))
                    .signWith(SignatureAlgorithm.HS512, secretKey)
                    .compact();
            return token;
        } catch (Exception e) {
            throw new UsernameNotFoundException("Username topilmadi");
        }
    }

    public String getUsernameFromToken(String token) {
        try {
                // validation
            if (validateToken(token)) {
                String username = Jwts.parser()
                        .setSigningKey(secretKey)
                        .parseClaimsJws(token)
                        .getBody()
                        .getSubject();
                return username;
            }

        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
        } catch (MalformedJwtException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration().after(new Date());
            return true;
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
        } catch (MalformedJwtException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return false;
    }


}
