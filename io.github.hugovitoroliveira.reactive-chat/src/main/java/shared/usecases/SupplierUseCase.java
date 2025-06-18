package shared.usecases;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 17/06/25
 */
public abstract class SupplierUseCase<OUTPUT> {
    public abstract OUTPUT execute();
}
