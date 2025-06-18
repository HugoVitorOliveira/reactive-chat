package modules.user.resource;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import modules.user.usecases.create.CreateUserInput;
import modules.user.dtos.CreateUserRequest;
import modules.user.usecases.create.CreateUserUseCase;
import modules.user.usecases.list.ListUsersOutput;
import modules.user.usecases.list.ListUsersUseCase;

import java.util.List;
import java.util.UUID;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 13/06/25
 */
@Path("/user")
@RequiredArgsConstructor
public class UserResource {

    private final CreateUserUseCase createUserUseCase;

    private final ListUsersUseCase listUsersUseCase;
    @POST
    public Uni<UUID> create(final CreateUserRequest request) {
        final var input = CreateUserInput.builder()
            .name(request.getName())
            .password(request.getPassword())
            .email(request.getEmail())
            .build();

        return createUserUseCase.execute(input);
    }

    @GET
    public Uni<List<ListUsersOutput>> list() {
        return listUsersUseCase.execute();
    }
}
