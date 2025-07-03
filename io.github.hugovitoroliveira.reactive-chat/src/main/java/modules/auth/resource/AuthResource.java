package modules.auth.resource;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import modules.auth.dtos.LoginRequest;
import modules.auth.dtos.LoginResponse;
import modules.auth.usecases.login.LoginInput;
import modules.auth.usecases.login.LoginOutput;
import modules.auth.usecases.login.LoginUseCase;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 06/06/25
 */
@Tag(name = "Autenticação", description = "Rotas referentes a autenticação")
@Path("/auth")
@RequiredArgsConstructor
public class AuthResource {

    private final LoginUseCase loginUseCase;

    @PUT
    @Operation(summary = "Realiza o login")
    @Path("/login")
    @APIResponse(
        responseCode = "200",
        description = "Logado com sucesso",
        content = @Content(
            mediaType = MediaType.APPLICATION_JSON,
            schema = @Schema(implementation = LoginResponse.class)
        )
    )
    public Uni<LoginResponse> login(final LoginRequest loginRequest) {
        final var input = LoginInput.builder()
            .email(loginRequest.getEmail())
            .password(loginRequest.getPassword())
            .build();

        Uni<LoginOutput> output = loginUseCase.execute(input);

        return output.map(loginOutput -> LoginResponse.builder()
            .token(loginOutput.getToken())
            .build());
    }
}
