package projeto;

import java.util.Scanner;
import java.util.ArrayList;

public class MetodosBiblioteca {

    // Adicionar Novo Livro
    public static void adicionarLivro(Scanner sc, ArrayList<String> livros, ArrayList<String> autores) {
        System.out.print("\nDigite o título do livro: ");
        String titulo = sc.nextLine().trim();

        System.out.print("Digite o autor do livro: ");
        String autor = sc.nextLine().trim();

        if (titulo.isEmpty() || autor.isEmpty()) {
            System.out.println("\nPor favor, preencha todos os campos obrigatórios.\n");
            return;
        }

        livros.add(titulo);
        autores.add(autor);

        System.out.println("\nLivro adicionado com sucesso!\n");
    }

    // Listar Todos os Livros
    public static void listarLivros(ArrayList<String> livros, ArrayList<String> autores) {
        if (livros.isEmpty()) {
            System.out.println("\nNenhum livro cadastrado.\n");
        } else {
            System.out.println("\n--- Lista de Livros ---");
            for (int i = 0; i < livros.size(); i++) {
                System.out.println("Título: " + livros.get(i) + " | Autor: " + autores.get(i));
            }
            System.out.println("-----------------------\n");
        }
    }

    // Pesquisar Livro por Título
    public static void pesquisarLivro(Scanner sc, ArrayList<String> livros, ArrayList<String> autores) {
        System.out.print("\nDigite o título do livro procurado: ");
        String tituloProcurado = sc.nextLine().trim();

        int indice = buscarIndice(livros, tituloProcurado);

        if (indice != -1) {
            System.out.println("\n--- Livro Encontrado! ---");
            System.out.println("Título: " + livros.get(indice) + " | Autor: " + autores.get(indice));
            System.out.println("-----------------------\n");
        } else {
            System.out.println("\nLivro não encontrado.\n");
        }
    }

    // Excluir Livro pelo Título
    public static void excluirLivro(Scanner sc, ArrayList<String> livros, ArrayList<String> autores) {
        System.out.print("\nDigite o título do livro para ser removido: ");
        String tituloProcurado = sc.nextLine().trim();

        int indice = buscarIndice(livros, tituloProcurado);

        if (indice != -1) {
            System.out.print("\nDeseja excluir o livro '" + livros.get(indice) + "'? (Sim/Não): ");
            String confirmacaoDeDelet = sc.nextLine().trim().toLowerCase();

            if (confirmacaoDeDelet.equals("sim") || confirmacaoDeDelet.equals("s")) {
                livros.remove(indice);
                autores.remove(indice);
                System.out.println("\nLivro excluído com sucesso!\n");
            } else if (confirmacaoDeDelet.equals("não") || confirmacaoDeDelet.equals("nao") || confirmacaoDeDelet.equals("n")) {
                System.out.println("\nOperação cancelada.\n");
            } else {
                System.out.println("\nOperação falhou: entrada inválida.\n");
            }
        } else {
            // Feedback exato exigido no projeto
            System.out.println("\nOperação falhou: título não encontrado.\n");
        }
    }

    // Busca Indice do Livro
    private static int buscarIndice(ArrayList<String> livros, String tituloProcurado) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).equalsIgnoreCase(tituloProcurado)) {
                return i;
            }
        }
        return -1;
    }
}