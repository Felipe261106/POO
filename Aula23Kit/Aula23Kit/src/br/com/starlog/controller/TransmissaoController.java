package br.com.starlog.controller;

import br.com.starlog.model.CriptoMensagem;

public class TransmissaoController {

    private int totalTransmissoes = 0;

    public String processarTransmissao(String remetente, String mensagem, String chaveTexto) {
        int chave;
        try {
            chave = Integer.parseInt(chaveTexto.trim());
        } catch (NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("Chave deve ser um número inteiro.", e);
        }

        CriptoMensagem cripto = new CriptoMensagem(remetente, mensagem, chave);
        String pacote = "[" + cripto.getRemetente() + "] #"
                + cripto.calcularChecksum() + " -> " + cripto.cifrar();

        totalTransmissoes++; // só conta se tudo deu certo
        return pacote;
    }

    public int getTotalTransmissoes() {
        return totalTransmissoes;
    }
}