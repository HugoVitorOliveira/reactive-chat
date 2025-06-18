package modules.user.usecases.create;

import io.smallrye.mutiny.Uni;
import lombok.RequiredArgsConstructor;
import shared.usecases.UseCase;

import java.util.UUID;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 06/06/25
 */
@RequiredArgsConstructor
public abstract class CreateUserUseCase extends UseCase<CreateUserInput, Uni<UUID>> {

}
