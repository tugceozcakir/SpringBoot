package com.example.salesproject.util.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    // Secret anahtarı application.properties dosyasından alıyoruz
    @Value("${jwt.secret}")
    private String secret;

    // E-posta (email) bilgisini kullanarak JWT oluşturur
    public String generateToken(String email) throws IllegalArgumentException, JWTCreationException {
        return JWT.create()
                .withSubject("User Details") // Konu başlığı
                .withClaim("email", email) // E-posta bilgisi
                .withIssuedAt(new Date())   // Oluşturulma tarihi
                .withIssuer("ALLIANZ")      // Kimlik oluşturan
                .sign(Algorithm.HMAC256(secret)); // JWT imzalanıyor ve dönüyor
    }

    // Verilen token'ı doğrulayarak e-posta (email) bilgisini çeker
    public String validateTokenAndRetrieveSubject(String token) throws JWTVerificationException {
        // JWT doğrulayıcı oluşturuluyor
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret))
                .withSubject("User Details") // Konu başlığı
                .withIssuer("ALLIANZ") // Kimlik oluşturan
                .build();

        // Token doğrulanıyor ve e-posta bilgisi çekiliyor
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("email").asString();
    }
}
