package modules.auth.usecases.login;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 18/06/25
 */
@Getter
@Builder
public class LoginInput {
    private final String email;
    private final String password;
}
