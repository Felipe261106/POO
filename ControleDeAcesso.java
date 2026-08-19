package br.com.techcorp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ControleDeAcesso {

    
    private List<Funcionario> historicoCatraca;

    
    private Set<Funcionario> autorizadosSalaSegura;

    public ControleDeAcesso() {
        this.historicoCatraca = new ArrayList<>();
        this.autorizadosSalaSegura = new HashSet<>();
    }

    public void registrarPassagem(Funcionario f) {
        historicoCatraca.add(f);
        System.out.println("Passagem registrada na catraca: " + f.getNome());
    }

    public void concederAcessoSala(Funcionario f) {
        boolean adicionado = autorizadosSalaSegura.add(f);

        if (adicionado) {
            System.out.println("Acesso liberado para a Sala Segura");
        } else {
            System.out.println("Aviso: Matrícula já registrada na sala. Acesso não permitido.");
        }
    }

    public List<Funcionario> getHistoricoCatraca() {
        return historicoCatraca;
    }

    public Set<Funcionario> getAutorizadosSalaSegura() {
        return autorizadosSalaSegura;
    }
}
