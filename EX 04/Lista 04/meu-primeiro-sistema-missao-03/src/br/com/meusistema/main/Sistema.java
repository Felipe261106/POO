package br.com.meusistema.main;

import br.com.meusistema.model.Carro;

public class Sistema {

    public static void main(String[] args) {

        System.out.println("Iniciando o sistema...");

        // Carro 1
        Carro meuCarro = new Carro();

        meuCarro.setModelo("Fusca");
        meuCarro.setCor("Azul");
        meuCarro.setVelocidade(-500); // Tentando inserir uma velocidade inválida

        meuCarro.buzinar();

        // Carro 2 - desafio da Missão 02
        Carro carro2 = new Carro();

        carro2.setModelo("Civic");
        carro2.setCor("Preto");
        carro2.setVelocidade(120);

        carro2.buzinar();
    }
}
