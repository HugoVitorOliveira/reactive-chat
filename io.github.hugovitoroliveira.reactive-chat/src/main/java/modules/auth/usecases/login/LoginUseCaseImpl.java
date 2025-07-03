package modules.auth.usecases.login;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.NotFoundException;
import modules.auth.services.GenerateTokenService;
import modules.user.entity.UserEntity;
import modules.user.repository.UserRepository;
import shared.services.encrypt.CryptoStrategy;
import shared.services.encrypt.argon2.Argon2;

import java.util.UUID;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 18/06/25
 */
@RequestScoped
public class LoginUseCaseImpl extends LoginUseCase {

    @Inject
    private UserRepository userRepository;

    @Inject
    private GenerateTokenService generateTokenService;

    @Inject
    @Argon2
    private CryptoStrategy cryptoStrategy;

    @Override
    @WithSession
    public Uni<LoginOutput> execute(final LoginInput loginInput) {
        return userRepository.findByEmail(loginInput.getEmail())
            .onItem().ifNull().failWith(() -> new NotFoundException("Usuário não encontrado"))
            .invoke(user -> {
                boolean isValid = cryptoStrategy.verify(user.getPassword(), loginInput.getPassword());
                if (!isValid) {
                    throw new NotAuthorizedException("Senha inválida");
                }
            })
            .map(user -> {
                String token = generateTokenService.generate(user.getId());

                return LoginOutput.builder()
                    .token(token)
                    .build();
            });
    }
}
