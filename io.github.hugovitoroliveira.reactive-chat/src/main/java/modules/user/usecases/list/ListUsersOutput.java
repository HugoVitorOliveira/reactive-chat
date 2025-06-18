package modules.user.usecases.list;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 17/06/25
 */
@Getter
@Builder
public class ListUsersOutput {
    private String name;
    private String email;
    private String password;
}
