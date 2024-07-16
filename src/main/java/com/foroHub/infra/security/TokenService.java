package com.foroHub.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.foroHub.domain.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("voll med")
                    .withSubject(usuario.getLogin())
                    .withClaim("id",usuario.getId())
                    .withExpiresAt(geenrarFechaExpiracion())
                    .sign(algorithm);

        } catch (JWTCreationException exception) {
            throw new RuntimeException();
        }

    }

    public String getSubject(String token) {
        if (token == null || token.trim().isEmpty()) {
            throw new RuntimeException("Token is null or empty");
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            DecodedJWT verifier = JWT.require(algorithm)
                    .withIssuer("voll med")
                    .build()
                    .verify(token.trim());  // Asegúrate de eliminar cualquier espacio en blanco
            String subject = verifier.getSubject();
            if (subject == null) {
                throw new RuntimeException("Verifier is invalid");
            }
            return subject;
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Verifier problem: " + e.getMessage(), e);
        }
    }



    private Instant geenrarFechaExpiracion() {
        return LocalDateTime.now().plusMinutes(5).toInstant(ZoneOffset.of("-04:00"));
    }


}
