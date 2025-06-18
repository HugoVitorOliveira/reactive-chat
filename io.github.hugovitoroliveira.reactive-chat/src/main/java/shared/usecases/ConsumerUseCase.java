package shared.usecases;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 06/06/25
 */
public abstract class ConsumerUseCase<INPUT> {
    public abstract void execute(final INPUT input);
}
