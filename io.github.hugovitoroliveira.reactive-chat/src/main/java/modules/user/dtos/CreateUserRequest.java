package modules.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 13/06/25
 */

@Getter
@AllArgsConstructor
@Schema(description = "Payload necessário para criar um usuário")
public class CreateUserRequest {
    @Schema(description = "Nome do usuário", example = "John doe")
    private String name;

    @Schema(description = "Email do usuário", example = "johndoe@hotmail.com")
    private String email;

    @Schema(description = "Senha do usuário", example = "j0hnD03")
    private String password;
}
