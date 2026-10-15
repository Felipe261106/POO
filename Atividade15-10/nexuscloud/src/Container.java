import java.util.Objects;

// Representa uma aplicacao rodando dentro de um servidor.
public class Container {
    // Atributos privados (encapsulamento).
    private String id;
    private double ramNecessaria;

    // Construtor com todos os atributos. RA: [seu RA]
    public Container(String id, double ramNecessaria) {
        this.id = id;
        this.ramNecessaria = ramNecessaria;
    }

    // Getters e setters. RA: [seu RA]
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public double getRamNecessaria() { return ramNecessaria; }
    public void setRamNecessaria(double ramNecessaria) { this.ramNecessaria = ramNecessaria; }

    // Dois containers sao iguais se tem o mesmo ID.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.equals(id, ((Container) o).id);
    }

    // Mesmo campo do equals.
    @Override
    public int hashCode() { return Objects.hash(id); }
}
