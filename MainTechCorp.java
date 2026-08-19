package br.com.techcorp.main;

import br.com.techcorp.model.ControleDeAcesso;
import br.com.techcorp.model.Funcionario;

public class MainTechCorp {

    public static void main(String[] args) {

        ControleDeAcesso controle = new ControleDeAcesso();

        
        Funcionario f1 = new Funcionario("T-001", "Alice", "Analista");
        Funcionario f2 = new Funcionario("T-001", "Alice Duplicada", "Analista");

        System.out.println("=== Teste da Catraca (deve aceitar ambas as passagens) ===");
        controle.registrarPassagem(f1);
        controle.registrarPassagem(f2);

        System.out.println();
        System.out.println("=== Teste da Sala Segura (deve bloquear a segunda tentativa) ===");
        controle.concederAcessoSala(f1);
        controle.concederAcessoSala(f2);

        System.out.println();
        System.out.println("Histórico da catraca: " + controle.getHistoricoCatraca().size() + " registros");
        System.out.println("Autorizados na sala segura: " + controle.getAutorizadosSalaSegura().size() + " matrícula(s) única(s)");
    }
}
