package modules.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 13/06/25
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String name;

    private String email;

    private String password;
}
