package modules.user.usecases.list;

import io.smallrye.mutiny.Uni;
import shared.usecases.SupplierUseCase;

import java.util.List;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 17/06/25
 */
public abstract class ListUsersUseCase extends SupplierUseCase<Uni<List<ListUsersOutput>>> {
}
