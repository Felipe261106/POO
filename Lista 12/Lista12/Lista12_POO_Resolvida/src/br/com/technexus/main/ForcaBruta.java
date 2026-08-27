package br.com.technexus.main;

public class ForcaBruta {

    public static void main(String[] args) {
        String prefixo = "lam";
        String caracteres = "abcdefghijklmnopqrstuvwxyz0123456789";

        long totalCombinacoes = (long) Math.pow(caracteres.length(), 3);

        System.out.println("Prefixo conhecido: " + prefixo);
        System.out.println("Caracteres permitidos: " + caracteres);
        System.out.println("Combinações possíveis para os 3 últimos caracteres: "
                + totalCombinacoes);
        System.out.println("Exemplo inicial: lam000");
        System.out.println("Exemplo final: lamzzz");
        System.out.println("A etapa de tentativa contra o conteúdo cifrado não foi automatizada.");
    }
}
