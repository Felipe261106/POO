package br.com.banco.main;

import br.com.banco.model.Agencia;
import br.com.banco.model.Cliente;
import br.com.banco.model.ContaBancaria;

public class MainTeste {
    public static void main(String[] args) {
        // 1. Dois clientes diferentes, mas com o mesmo CPF.
        Cliente cliente1 = new Cliente("12345678900", "Joao", "joao@email.com");
        Cliente cliente2 = new Cliente("12345678900", "Maria", "maria@email.com");

        // 2. A igualdade deve considerar somente o CPF.
        if (cliente1.equals(cliente2)) {
            System.out.println("Os clientes são iguais.");
        } else {
            System.out.println("Os clientes são diferentes.");
        }

        // 3. Conta com saldo inicial de 50.0.
        ContaBancaria conta = new ContaBancaria("001", cliente1, 50.0);

        // 4. Saque de 50.0 deve ser negado, pois há taxa de 5.0.
        boolean resultadoSaque = conta.sacar(50.0);
        System.out.println("Resultado do saque de R$ 50,00: " + resultadoSaque);

        // Comprovação de que o saldo não foi alterado.
        System.out.println("Saldo atual: R$ " + conta.getSaldo());

        // 5. Total de contas abertas.
        System.out.println("Total de contas abertas: " + Agencia.getTotalContasAbertas());
    }
}
