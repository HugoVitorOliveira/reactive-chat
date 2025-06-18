package modules.user.usecases.create;

import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import modules.user.entity.UserEntity;
import modules.user.repository.UserRepository;
import shared.services.encrypt.argon2.Argon2Qualifier;
import shared.services.encrypt.CryptoStrategy;

import java.util.UUID;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 06/06/25
 */
@RequestScoped
public class CreateUserUseCaseImpl extends  CreateUserUseCase {

    @Inject
    private UserRepository userRepository;

    @Inject
    @Argon2Qualifier
    private CryptoStrategy cryptoStrategy;

    @Override
    @WithTransaction
    public Uni<UUID> execute(final CreateUserInput createUserInput) {
        UserEntity entity = new UserEntity();
        entity.setId(UUID.randomUUID());
        entity.setPassword(cryptoStrategy.encrypt(createUserInput.getPassword()));
        entity.setName(createUserInput.getName());
        entity.setEmail(createUserInput.getEmail());

        return userRepository.persist(entity).map(UserEntity::getId);
    }
}
