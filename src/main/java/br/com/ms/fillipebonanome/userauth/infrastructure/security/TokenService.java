package br.com.ms.fillipebonanome.userauth.infrastructure.security;

import br.com.ms.fillipebonanome.userauth.domain.entities.User;
import br.com.ms.fillipebonanome.userauth.domain.service.TokenGeneratorInterface;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService implements TokenGeneratorInterface {

    @Value("${api.security.token.secret}")
    private String secret;
    private final String issuer = "PROGRAMMING_LINGO";

    @Override
    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create().
                    withIssuer(issuer)
                    .withSubject(user.getEmail())
                    .withExpiresAt(expirationDate())
                    .withClaim("permissions", user.getPermissions())
                    .withClaim("role", user.getRole().toString())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error generating JWT Token", exception);
        }
    }

    @Override
    public String getSubject(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        }
        catch (JWTVerificationException exception) {
            throw new RuntimeException("Token is invalid or expired");
        }
    }

    public Instant expirationDate() {
        return LocalDateTime.now().plusHours(6).toInstant(ZoneOffset.of("-03:00"));
    }
}
