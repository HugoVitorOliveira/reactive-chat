package modules.user.usecases.list;

import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.RequestScoped;
import lombok.RequiredArgsConstructor;
import modules.user.repository.UserRepository;

import java.util.List;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 17/06/25
 */

@RequestScoped
@RequiredArgsConstructor
public class ListUsersUseCaseImpl extends ListUsersUseCase {

    private final UserRepository userRepository;

    @Override
    @WithSession
    public Uni<List<ListUsersOutput>> execute() {
        return userRepository.listAll()
            .map(users -> users.stream()
                .map(user -> ListUsersOutput.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .build()
                )
                .toList()
            );
    }
}
