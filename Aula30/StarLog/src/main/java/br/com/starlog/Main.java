package br.com.starlog;

import br.com.starlog.dao.ProdutoDAO;
import br.com.starlog.dao.ProdutoDAOSqlite;
import br.com.starlog.model.Produto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAOSqlite();

        System.out.println("========================================");
        System.out.println("       SISTEMA ALMOXARIFADO STARLOG");
        System.out.println("========================================");

        // CREATE
        System.out.println("\n[1] CADASTRANDO PRODUTOS");
        Produto teclado = new Produto("Teclado Mecânico RGB", 259.90, 10);
        Produto mousepad = new Produto("Mousepad Speed XL", 79.90, 20);

        dao.salvar(teclado);
        dao.salvar(mousepad);

        System.out.println("Teclado cadastrado! ID: " + teclado.getId());
        System.out.println("Mousepad cadastrado! ID: " + mousepad.getId());

        // READ
        System.out.println("\n[2] LISTAGEM DE PRODUTOS");
        imprimirTabela(dao.listarTodos());

        // UPDATE
        System.out.println("\n[3] ATUALIZANDO TECLADO");
        teclado.setEstoque(15);
        teclado.setPreco(289.90);

        boolean atualizado = dao.atualizar(teclado);
        if (atualizado) {
            System.out.println("Produto atualizado com sucesso!");
            dao.buscarPorId(teclado.getId()).ifPresent(System.out::println);
        } else {
            System.out.println("Produto não encontrado para atualização.");
        }

        // DELETE
        System.out.println("\n[4] EXCLUINDO PRODUTOS");
        boolean excluido = dao.excluir(mousepad.getId());

        if (excluido) {
            System.out.println("Mousepad excluído com sucesso!");
        } else {
            System.out.println("Mousepad não encontrado.");
        }

        boolean inexistente = dao.excluir(888L);
        if (inexistente) {
            System.out.println("Produto 888 excluído.");
        } else {
            System.out.println("ID 888 não encontrado. Nenhum registro foi removido.");
        }

        // FINAL STATE
        System.out.println("\n[5] ESTADO FINAL DO ESTOQUE");
        List<Produto> listaFinal = dao.listarTodos();
        imprimirTabela(listaFinal);
        System.out.println("Total de produtos restantes: " + listaFinal.size());

        if (listaFinal.size() == 1) {
            System.out.println("Teste final aprovado: restou exatamente 1 produto.");
        } else {
            System.out.println("Atenção: confira o banco. O teste esperado considera banco inicialmente vazio.");
        }

        System.out.println("\n========================================");
        System.out.println("       PROCESSO FINALIZADO!");
        System.out.println("========================================");
    }

    private static void imprimirTabela(List<Produto> produtos) {
        System.out.printf("%-5s %-28s %-14s %-10s%n",
                "ID", "NOME", "PREÇO", "ESTOQUE");
        System.out.println("---------------------------------------------------------------");

        for (Produto p : produtos) {
            System.out.printf("%-5d %-28s R$ %-11.2f %-10d%n",
                    p.getId(), p.getNome(), p.getPreco(), p.getEstoque());
        }
    }
}
