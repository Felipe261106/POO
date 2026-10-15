import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Servidor virtual que hospeda containers.
public class Servidor {
    // Atributos privados (encapsulamento).
    private String ip;
    private double ramTotal;
    private double precoPorHora;
    private boolean statusLigado; // nasce false (desligado).

    // Lista cronologica de containers, inicializada na declaracao para evitar NullPointerException.
    private List<Container> containers = new ArrayList<>();

    // Construtor: o servidor sempre nasce desligado.
    public Servidor(String ip, double ramTotal, double precoPorHora) {
        this.ip = ip;
        this.ramTotal = ramTotal;
        this.precoPorHora = precoPorHora;
        this.statusLigado = false;
    }

    // Liga o servidor.
    public void ligar() { this.statusLigado = true; }

    // Getters e setters.
    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }
    public double getRamTotal() { return ramTotal; }
    public void setRamTotal(double ramTotal) { this.ramTotal = ramTotal; }
    public double getPrecoPorHora() { return precoPorHora; }
    public void setPrecoPorHora(double precoPorHora) { this.precoPorHora = precoPorHora; }
    public boolean isStatusLigado() { return statusLigado; }
    public List<Container> getContainers() { return containers; }

    // RN04: soma a RAM dos containers alocados usando Streams
    public double calcularRamEmUso() {
        return containers.stream()
                .mapToDouble(Container::getRamNecessaria) // extrai a RAM de cada container
                .sum();                                    // soma total
    }

    // RN03: Fail-Fast - valida antes de alocar. "throws" e obrigatorio por causa da excecao checked.
    public void alocarContainer(Container c) throws CapacidadeExcedidaException {
        // Regra de Status (unchecked): servidor desligado nao aceita containers.
        if (!statusLigado) {
            throw new ServidorOfflineException(
                "Erro: Não é possível alocar containers em um servidor desligado.");
        }
        // Regra de Capacidade (checked): RAM em uso + RAM do novo container nao pode passar do total
        if (calcularRamEmUso() + c.getRamNecessaria() > ramTotal) {
            throw new CapacidadeExcedidaException(
                "Falha Crítica: Memória RAM insuficiente no servidor " + ip + ".");
        }
        // So chega aqui se passou nas duas validacoes.
        containers.add(c);
    }

    // Dois servidores sao iguais se tem o mesmo IP.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(ip, ((Servidor) o).ip);
    }

    // Mesmo campo do equals.
    @Override
    public int hashCode() { return Objects.hash(ip); }
}
