package modules.user.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import modules.user.entity.UserEntity;

import java.util.Optional;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 06/06/25
 */
@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {

    public Uni<UserEntity> findByEmail(final String email) {
        return find("email", email).firstResult();
    }
}
