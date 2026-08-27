package br.com.nexustech.main;

import br.com.nexustech.exception.BanidoException;
import br.com.nexustech.model.Masmorra;
import br.com.nexustech.model.Matchmaker;
import br.com.nexustech.model.ModoCasual;
import br.com.nexustech.model.ModoJogo;
import br.com.nexustech.model.ModoRanqueado;

public class Main {

    public static void main(String[] args) {

        // Exercicios 1 e 2 - Divisao por zero
        int kills = 15;
        int deaths = 0;

        try {
            System.out.println(kills / deaths);
        } catch (ArithmeticException e) {
            System.out.println("Taxa K/D: Jogador Invicto!");
        }

        // Exercicio 3 - Inventario bugado
        String[] inventario = new String[3];

        try {
            inventario[5] = "Espada";
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Inventário cheio!");
        }

        // Exercicio 4 - NullPointerException com programacao defensiva
        String jogador = null;

        if (jogador != null) {
            System.out.println(jogador);
        } else {
            System.out.println("Jogador desconectado");
        }

        // Exercicios 5, 6 e 7 - Queda de internet
        try {
            conectarServidor();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Fechando portas de rede do jogo...");
        }

        // Exercicios 8 e 9 - Excecao personalizada / Masmorra
        Masmorra masmorra = new Masmorra();

        try {
            masmorra.entrar(20);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // Boss - Matchmaker
        Matchmaker matchmaker = new Matchmaker();

        ModoJogo modoCasual = new ModoCasual();
        ModoJogo modoRanqueado = new ModoRanqueado();

        try {
            matchmaker.encontrarSala(modoCasual, true);
        } catch (BanidoException e) {
            System.out.println(e.getMessage());
        }

        try {
            matchmaker.encontrarSala(modoRanqueado, false);
        } catch (BanidoException e) {
            System.out.println(e.getMessage());
        }
    }

    // Exercicio 5
    public static void conectarServidor() throws Exception {
        throw new Exception("Servidor caiu!");
    }
}
