package shared.usecases;

/**
 * @author Hugo Vitor de Oliveira Moura <hugo.moura@nexuscloud.com.br>
 * @since 06/06/25
 */
public abstract class UseCase<INPUT, OUTPUT> {
    public abstract OUTPUT execute(final INPUT input);
}
