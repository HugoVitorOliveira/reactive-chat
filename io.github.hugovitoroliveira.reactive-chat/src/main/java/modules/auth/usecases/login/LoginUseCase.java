package modules.auth.usecases.login;

import io.smallrye.mutiny.Uni;
import shared.usecases.UseCase;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 18/06/25
 */
public abstract class LoginUseCase extends UseCase<LoginInput, Uni<LoginOutput>> {
}
