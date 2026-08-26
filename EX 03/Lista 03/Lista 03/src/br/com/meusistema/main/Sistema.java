package br.com.meusistema.main;

import br.com.meusistema.model.Carro;

public class Sistema {

    public static void main(String[] args) {

        System.out.println("Iniciando o sistema...");

        // Criando o Carro 1
        Carro meuCarro = new Carro();
        meuCarro.modelo = "Fusca";
        meuCarro.cor = "Azul";

        // Chamando o metodo
        meuCarro.buzinar();

        // Desafio Rapido: Criando o Carro 2
        Carro carro2 = new Carro();
        carro2.modelo = "Civic";
        carro2.cor = "Preto";

        carro2.buzinar();
    }
}
