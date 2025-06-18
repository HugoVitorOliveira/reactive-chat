package modules.user.usecases.create;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 06/06/25
 */
@Getter
@Builder
public class CreateUserInput {
    private String name;

    private String email;

    private String password;
}
