// Classe executavel com o roteiro de testes da atividade.
// "throws" no main so existe para permitir o Passo 6 sem try-catch.
public class MainCloud {
    public static void main(String[] args) throws CapacidadeExcedidaException {
        // 1. Instancia o CloudManager.
        CloudManager manager = new CloudManager();

        // 2. Instancia 1 Cliente.
        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");

        // 3. Instancia 1 Servidor (nasce desligado).
        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50);

        // 4. Registra o cliente no banco e adiciona o servidor a ele.
        manager.registrarCliente(cliente);
        manager.adicionarServidor(cliente, servidor);

        // 5. Instancia 2 Containers diferentes.
        Container c1 = new Container("C-01", 10.0);
        Container c2 = new Container("C-02", 8.0);

        // 6. Falha UNCHECKED: servidor desligado. Sem try-catch de proposito.
        //    Foi testado e comentado para o programa poder prosseguir.
        // servidor.alocarContainer(c1);

        // 7. Liga o servidor.
        servidor.ligar();

        // 8 e 9. Aloca C-01 (sucesso) e tenta C-02 (10 + 8 = 18 > 16 -> CapacidadeExcedidaException).
        try {
            servidor.alocarContainer(c1);
            System.out.println("Container " + c1.getId() + " alocado com sucesso.");
            servidor.alocarContainer(c2);
        } catch (CapacidadeExcedidaException e) {
            // Erro CHECKED tratado de forma elegante.
            System.out.println(e.getMessage());
        }

        // 10. Fatura ativa: servidor ligado com preco 5.50 -> 5.5.
        System.out.println("Fatura ativa: " + manager.calcularFaturaAtiva(cliente));
    }
}
