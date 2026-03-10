package projeto;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class ProjetoBiblioteca {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> livros = new ArrayList<>();
        ArrayList<String> autores = new ArrayList<>();

        int opcao = 0;

        do {
            System.out.println("--- Menu ---");
            System.out.println("1 - Adicionar Novo Livro");
            System.out.println("2 - Pesquisar Livro por Título");
            System.out.println("3 - Excluir Livro pelo Título");
            System.out.println("4 - Listar Todos os Livros");
            System.out.println("5 - Sair do Sistema");
            System.out.print("Qual a sua opção? ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> MetodosBiblioteca.adicionarLivro(scanner, livros, autores);
                    case 2 -> MetodosBiblioteca.pesquisarLivro(scanner, livros, autores);
                    case 3 -> MetodosBiblioteca.excluirLivro(scanner, livros, autores);
                    case 4 -> MetodosBiblioteca.listarLivros(livros, autores);
                    case 5 -> System.out.println("\nSaindo do Sistema...\n");
                    default -> System.out.println("\nOpção inválida. Tente novamente.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nEntrada inválida. Por favor, digite apenas números.\n");
                scanner.nextLine();
            }
        } while (opcao != 55);

        scanner.close();
    }
}