package br.com.starlog.model;

public class CriptoMensagem {

    private final String remetente;
    private final String mensagem;
    private final int chave;

    public CriptoMensagem(String remetente, String mensagem, int chave) {
        if (remetente == null || remetente.isBlank()) {
            throw new IllegalArgumentException("Remetente não pode ser nulo ou em branco.");
        }
        if (mensagem == null) {
            throw new IllegalArgumentException("Mensagem não pode ser nula.");
        }
        if (chave < 1 || chave > 25) {
            throw new IllegalArgumentException("Chave deve estar entre 1 e 25.");
        }
        this.remetente = remetente;
        this.mensagem = mensagem;
        this.chave = chave;
    }

    public String cifrar() {
        StringBuilder sb = new StringBuilder();
        for (char c : mensagem.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) ('A' + (c - 'A' + chave) % 26));
            } else if (c >= 'a' && c <= 'z') {
                sb.append((char) ('a' + (c - 'a' + chave) % 26));
            } else {
                sb.append(c); // espaços, números e pontuação ficam iguais
            }
        }
        return sb.toString();
    }

    public int calcularChecksum() {
        int soma = 0;
        for (char c : mensagem.toCharArray()) {
            soma += c;
        }
        return soma;
    }

    public String getRemetente() {
        return remetente;
    }
}
