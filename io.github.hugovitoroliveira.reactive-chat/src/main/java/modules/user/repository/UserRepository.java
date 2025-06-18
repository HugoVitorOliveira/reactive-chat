package modules.user.repository;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import modules.user.entity.UserEntity;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 06/06/25
 */
@ApplicationScoped
public class UserRepository implements PanacheRepository<UserEntity> {
}
