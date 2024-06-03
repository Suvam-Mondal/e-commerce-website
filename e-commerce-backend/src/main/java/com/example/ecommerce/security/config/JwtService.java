package com.example.ecommerce.security.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Slf4j
@Service
public class JwtService {

    private String SECRET_KEY;
    private Date expiresIn;

    public JwtService() {
        SECRET_KEY = generateSecretKey();
    }

    public String generateToken(String userEmailId) {

        Map<String, Object> claims = new HashMap<String, Object>();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userEmailId)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(setExpiryTime())
                .signWith(SignatureAlgorithm.HS256, getKey())
                .compact();
    }

    private Date setExpiryTime() {
        expiresIn = new Date(System.currentTimeMillis() + 1000 * 60 * 3); // 3 minutes
        return expiresIn;
    }

    public Date getExpiryTime() {
        return expiresIn;
    }

    private String generateSecretKey() {
        // Create a KeyGenerator instance for AES algorithm
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);

        }

        // Generate a secret key
        SecretKey secretKey = keyGenerator.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());

    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new java.util.Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getKey() {
        byte[] key = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(key);
    }

}
