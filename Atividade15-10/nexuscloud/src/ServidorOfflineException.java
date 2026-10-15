// Excecao UNCHECKED (estende RuntimeException): o compilador nao obriga try-catch.
public class ServidorOfflineException extends RuntimeException {
    // Repassa a mensagem para a classe pai. RA: [seu RA]
    public ServidorOfflineException(String mensagem) {
        super(mensagem);
    }
}
