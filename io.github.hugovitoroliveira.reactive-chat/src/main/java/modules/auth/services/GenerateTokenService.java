package modules.auth.services;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.time.Instant;
import java.util.UUID;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 21/06/25
 */
@ApplicationScoped
public class GenerateTokenService {

    @ConfigProperty(name="mp.jwt.verify.issuer")
    private String issuer;

    public String generate(final UUID idUser) {
        final var oneHourInSeconds = 3600;
        long nowInSeconds = Instant.now().getEpochSecond();
        long expirationTime = nowInSeconds + oneHourInSeconds;

        return Jwt.issuer(issuer)
            .claim("sub", idUser.toString())
            .claim("exp", expirationTime)
            .claim("iat", nowInSeconds)
            .sign();
    }
}
