package modules.auth.dtos;

import lombok.Getter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 21/06/25
 */
@Getter
@Schema(description = "Payload necessário para realizar o login")
public class LoginRequest {
    @Schema(description = "Email do usuário", example = "johndoe@hotmail.com")
    private String email;

    @Schema(description = "Senha do usuário", example = "j03nd03")
    private String password;
}
