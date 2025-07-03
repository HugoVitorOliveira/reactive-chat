package shared.services.encrypt.argon2;

import de.mkammerer.argon2.Argon2Factory;
import jakarta.enterprise.context.RequestScoped;
import shared.services.encrypt.CryptoStrategy;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 13/06/25
 */
@Argon2
@RequestScoped
public class Argon2Crypto implements CryptoStrategy {
    private final de.mkammerer.argon2.Argon2 argon2 = Argon2Factory.create();

    public String encrypt(final String value) {
        final int iterations = 2;
        final int memoryUsage = 65536;
        final int threads = 1;

        return argon2.hash(iterations, memoryUsage, threads, value.toCharArray());
    }

    @Override
    public String decrypt(final String encrypted) {
        throw new UnsupportedOperationException("Decrypt operation is not supported for Argon2");
    }

    public boolean verify(final String encrypted, final String value) {
        return argon2.verify(encrypted, value.toCharArray());
    }
}
