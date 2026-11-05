package br.com.bookstore;

import br.com.bookstore.dao.LivroDAO;
import br.com.bookstore.dao.LivroDAOSqlite;
import br.com.bookstore.model.Livro;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Instanciação utilizando DIP
        LivroDAO dao = new LivroDAOSqlite();

        // 2. Cadastro de três livros
        System.out.println("=== CADASTRANDO LIVROS ===");

        Livro livro1 = new Livro("Clean Code", "Robert C. Martin", 89.90);
        Livro livro2 = new Livro("Design Patterns", "Erich Gamma", 99.90);
        Livro livro3 = new Livro("Refactoring", "Martin Fowler", 79.90);

        dao.salvar(livro1);
        dao.salvar(livro2);
        dao.salvar(livro3);

        System.out.println("Livro cadastrado com ID: " + livro1.getId());
        System.out.println("Livro cadastrado com ID: " + livro2.getId());
        System.out.println("Livro cadastrado com ID: " + livro3.getId());


        // 3. Consulta do livro de ID 2
        System.out.println("\n=== CONSULTANDO LIVRO ID 2 ===");

        dao.buscarPorId(2L).ifPresentOrElse(
            livro -> System.out.println(livro),
            () -> System.out.println("Livro não encontrado!")
        );


        // 4. Consulta de um ID inexistente
        System.out.println("\n=== CONSULTANDO ID INEXISTENTE ===");

        dao.buscarPorId(999L).ifPresentOrElse(
            livro -> System.out.println(livro),
            () -> System.out.println("Nenhum livro encontrado com esse ID.")
        );


        // 5. Listagem de todos os livros
        System.out.println("\n=== LISTA DE TODOS OS LIVROS ===");

        List<Livro> livros = dao.listarTodos();

        System.out.printf("%-5s %-25s %-25s %10s%n",
                "ID", "TÍTULO", "AUTOR", "PREÇO");

        System.out.println("-----------------------------------------------------------------------");

        for (Livro livro : livros) {
            System.out.printf("%-5d %-25s %-25s R$ %8.2f%n",
                    livro.getId(),
                    livro.getTitulo(),
                    livro.getAutor(),
                    livro.getPreco());
        }
    }
}