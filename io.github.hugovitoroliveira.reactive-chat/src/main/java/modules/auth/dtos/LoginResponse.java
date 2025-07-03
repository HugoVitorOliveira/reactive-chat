package modules.auth.dtos;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 22/06/25
 */
@Getter
@Builder
public class LoginResponse {
    private String token;
}
