package modules.user.dtos;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 17/06/25
 */
@Getter
@Builder
public class ListUsersResponse {
    private String name;
    private String email;
    private String password;
}
