package modules.user.resource;

import io.quarkus.security.Authenticated;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import lombok.RequiredArgsConstructor;
import modules.user.usecases.create.CreateUserInput;
import modules.user.dtos.CreateUserRequest;
import modules.user.usecases.create.CreateUserUseCase;
import modules.user.usecases.list.ListUsersOutput;
import modules.user.usecases.list.ListUsersUseCase;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;
import java.util.UUID;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 13/06/25
 */
@Path("/user")
@Tag(name = "Usuário", description = "Rotas referentes aos usuários")
@RequiredArgsConstructor
public class UserResource {

    private final CreateUserUseCase createUserUseCase;

    private final ListUsersUseCase listUsersUseCase;

    @POST
    @Operation(summary = "Cria um usuário")
    @APIResponse(
        responseCode = "200",
        description = "",
        content = @Content(
            mediaType = MediaType.TEXT_PLAIN,
            schema = @Schema(type = SchemaType.STRING, format = "uuid"),
            examples = @ExampleObject(value = "123e4567-e89b-12d3-a456-426614174000")
        )
    )
    public Uni<UUID> create(final CreateUserRequest request) {
        final var input = CreateUserInput.builder()
            .name(request.getName())
            .password(request.getPassword())
            .email(request.getEmail())
            .build();

        return createUserUseCase.execute(input);
    }

    @GET
    @Operation(summary = "Lista os usuários")
    public Uni<List<ListUsersOutput>> list() {
        return listUsersUseCase.execute();
    }
}
