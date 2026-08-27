package br.com.cybercorp.main;

import br.com.cybercorp.model.Credencial;
import br.com.cybercorp.model.Departamento;
import br.com.cybercorp.model.Funcionario;
import br.com.cybercorp.model.SistemaSeguranca;
import br.com.cybercorp.model.Veiculo;

public class MainTeste {

    public static void main(String[] args) {
        Departamento departamento =
                new Departamento("TI", "Tecnologia da Informação", 3);

        Funcionario funcionario =
                new Funcionario("FUNC-001", "Felipe", departamento);

        Veiculo veiculo =
                new Veiculo("ABC-1234", "Toyota Corolla", funcionario);

        SistemaSeguranca sistema = new SistemaSeguranca(2);

        Credencial c1 =
                new Credencial("FFF-999", true, funcionario);

        Credencial clone =
                new Credencial("FFF-999", true, funcionario);

        System.out.println("=== TESTE DA CATRACA ===");
        sistema.registrarCatraca(funcionario);
        sistema.registrarCatraca(funcionario);

        System.out.println("\n=== TESTE DO COFRE ===");
        sistema.acessarCofre(c1);
        sistema.acessarCofre(clone);

        System.out.println("\n=== TESTE DA GARAGEM ===");
        sistema.estacionarVeiculo(veiculo, 0);

        // Teste solicitado: a vaga 5 não existe em uma garagem de 2 vagas.
        sistema.estacionarVeiculo(veiculo, 5);
    }
}
