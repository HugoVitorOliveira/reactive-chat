package shared.services.encrypt;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 13/06/25
 */
public interface CryptoStrategy {
    public String encrypt(final String value);

    public String decrypt(final String encrypted);

    public boolean verify(final String encrypted, final String value);
}
