// Excecao CHECKED (estende Exception): o compilador obriga tratar (try-catch) ou declarar (throws)
public class CapacidadeExcedidaException extends Exception {
    // Repassa a mensagem para a classe pai.
    public CapacidadeExcedidaException(String mensagem) {
        super(mensagem);
    }
}
