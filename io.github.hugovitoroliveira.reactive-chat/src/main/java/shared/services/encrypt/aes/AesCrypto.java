package shared.services.encrypt.aes;

import jakarta.enterprise.context.RequestScoped;
import shared.services.encrypt.CryptoStrategy;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 13/06/25
 */
@AesQualifier
@RequestScoped
public class AesCrypto implements CryptoStrategy {

    @Override
    public String encrypt(final String value) {
        return "";
    }

    @Override
    public String decrypt(final String encrypted) {
        return "";
    }

    @Override
    public boolean verify(final String encrypted, final String value) {
        return false;
    }
}
