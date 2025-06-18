package core.jwt;

import io.smallrye.jwt.KeyFormat;
import io.smallrye.jwt.algorithm.SignatureAlgorithm;
import io.smallrye.jwt.auth.principal.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jose4j.jwt.consumer.JwtContext;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 18/06/25
 */

@ApplicationScoped
@Alternative
public class JwtVerifier extends JWTCallerPrincipalFactory {

    @ConfigProperty(name = "app.jwt.issuer")
    String issuer;

    @ConfigProperty(name = "app.jwt.secret")
    String secret;

    @Override
    public JWTCallerPrincipal parse(final String token,
        final JWTAuthContextInfo jwtAuthContextInfo) throws ParseException {

        final SecretKey secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
            "HmacSHA256");

        jwtAuthContextInfo.setKeyFormat(KeyFormat.PEM_KEY);
        jwtAuthContextInfo.setSecretVerificationKey(secretKey);
        jwtAuthContextInfo.setSignatureAlgorithm(Collections.singleton(SignatureAlgorithm.HS256));
        jwtAuthContextInfo.setIssuedBy(issuer);
        jwtAuthContextInfo.setRelaxVerificationKeyValidation(true);

        final JwtContext jwtContext = new DefaultJWTTokenParser().parse(token, jwtAuthContextInfo);

        return new DefaultJWTCallerPrincipal(jwtContext.getJwtClaims());
    }
}

