import java.util.Objects;

// Classe POJO que representa o cliente da NexusCloud.
public class Cliente {
    // Atributos privados = encapsulamento rigoroso.
    private String cpf;
    private String nome;

    // Construtor que recebe todos os dados do cliente.
    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // Getters e setters necessarios para acessar/alterar os atributos privados.
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    // Identidade logica: dois clientes sao iguais se tem o mesmo CPF.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente outro = (Cliente) o;
        return Objects.equals(cpf, outro.cpf);
    }

    // hashCode usa o mesmo campo do equals (contrato Java); necessario para o HashMap.
    @Override
    public int hashCode() { return Objects.hash(cpf); }
}
