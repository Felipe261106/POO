import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// "Banco de dados" principal do sistema.
public class CloudManager {
    // Map baseado em Hash (HashMap); chave = Cliente, valor = Set de Servidores (HashSet: sem duplicados e sem ordem).
    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>();

    // Registra o cliente com um conjunto vazio de servidores (nao sobrescreve se ja existir).
    public void registrarCliente(Cliente c) {
        bancoDeDados.putIfAbsent(c, new HashSet<>());
    }

    // Adiciona o servidor ao conjunto do cliente (cria o conjunto se necessario).
    public void adicionarServidor(Cliente c, Servidor s) {
        bancoDeDados.computeIfAbsent(c, k -> new HashSet<>()).add(s);
    }

    // RN04: fatura ativa apenas com Streams (sem for e sem if).
    public double calcularFaturaAtiva(Cliente c) {
        return bancoDeDados.getOrDefault(c, new HashSet<>()).stream() // servidores do cliente
                .filter(Servidor::isStatusLigado)                      // deixa passar APENAS os LIGADOS
                .mapToDouble(Servidor::getPrecoPorHora)                // extrai o preco por hora
                .sum();                                                // soma final
    }
}
