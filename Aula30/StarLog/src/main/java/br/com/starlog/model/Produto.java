package br.com.starlog.model;

public class Produto {
    private Long id;
    private String nome;
    private double preco;
    private int estoque;

    // Construtor de persistência: utilizado ao recuperar dados do banco.
    public Produto(Long id, String nome, double preco, int estoque) {
        validarNome(nome);
        validarPreco(preco);
        validarEstoque(estoque);

        this.id = id;
        this.nome = nome.trim();
        this.preco = preco;
        this.estoque = estoque;
    }

    // Construtor de negócio: utilizado para cadastrar um novo produto.
    public Produto(String nome, double preco, int estoque) {
        this(null, nome, preco, estoque);
    }

    private void validarNome(String nome) {
        if (nome == null || nome.trim().length() < 3) {
            throw new IllegalArgumentException(
                "O nome deve possuir pelo menos 3 caracteres."
            );
        }
    }

    private void validarPreco(double preco) {
        if (!(preco > 0.0) || Double.isInfinite(preco)) {
            throw new IllegalArgumentException(
                "O preço deve ser maior que zero."
            );
        }
    }

    private void validarEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException(
                "O estoque não pode ser negativo."
            );
        }
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPreco(double preco) {
        validarPreco(preco);
        this.preco = preco;
    }

    public void setEstoque(int estoque) {
        validarEstoque(estoque);
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %d | Nome: %s | Preço: R$ %.2f | Estoque: %d",
            id, nome, preco, estoque
        );
    }
}
