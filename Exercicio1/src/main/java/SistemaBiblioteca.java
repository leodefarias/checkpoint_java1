import java.io.*;
import java.util.*;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n--- Sistema Biblioteca ---");
                System.out.println("1. Adicionar Livro");
                System.out.println("2. Remover Livro");
                System.out.println("3. Registrar Membro");
                System.out.println("4. Registrar Empréstimo");
                System.out.println("5. Devolver Livro");
                System.out.println("6. Salvar Dados em Arquivo");
                System.out.println("7. Carregar Dados do Arquivo");
                System.out.println("8. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o título do livro: ");
                        String tituloLivro = scanner.nextLine();
                        System.out.print("Digite o autor do livro: ");
                        String autorLivro = scanner.nextLine();
                        System.out.print("Digite o ISBN do livro: ");
                        String isbnLivro = scanner.nextLine();
                        Livro novoLivro = new Livro(tituloLivro, autorLivro, isbnLivro);
                        biblioteca.adicionarLivro(novoLivro);
                        break;

                    case 2:
                        System.out.print("Digite o ISBN do livro que deseja remover: ");
                        String isbnRemover = scanner.nextLine();
                        Livro livroRemover = biblioteca.getLivros().stream()
                                .filter(l -> l.getISBN().equals(isbnRemover))
                                .findFirst()
                                .orElse(null);

                        if (livroRemover != null) {
                            biblioteca.removerLivro(livroRemover);
                        } else {
                            System.out.println("Livro não encontrado!");
                        }
                        break;

                    case 3:
                        System.out.print("Digite o nome do membro: ");
                        String nomeMembro = scanner.nextLine();
                        System.out.print("Digite o ID do membro: ");
                        int idMembro = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o email do membro: ");
                        String emailMembro = scanner.nextLine();
                        Membro novoMembro = new Membro(nomeMembro, idMembro, emailMembro);
                        biblioteca.registrarMembro(novoMembro);
                        break;

                    case 4:
                        System.out.print("Digite o ISBN do livro a ser emprestado: ");
                        String isbnEmprestimo = scanner.nextLine();
                        System.out.print("Digite o ID do membro que fará o empréstimo: ");
                        int idEmprestimo = scanner.nextInt();
                        scanner.nextLine();

                        Livro livroEmprestimo = biblioteca.getLivros().stream()
                                .filter(l -> l.getISBN().equals(isbnEmprestimo))
                                .findFirst()
                                .orElse(null);

                        Membro membroEmprestimo = biblioteca.getMembros().stream()
                                .filter(m -> m.getId() == idEmprestimo)
                                .findFirst()
                                .orElse(null);

                        if (livroEmprestimo != null && membroEmprestimo != null) {
                            biblioteca.registrarEmprestimo(livroEmprestimo, membroEmprestimo);
                        } else {
                            System.out.println("Livro ou membro não encontrado!");
                        }
                        break;

                    case 5:
                        System.out.print("Digite o ISBN do livro que deseja devolver: ");
                        String isbnDevolucao = scanner.nextLine();
                        System.out.print("Digite o ID do membro que está devolvendo o livro: ");
                        int idDevolucao = scanner.nextInt();
                        scanner.nextLine();

                        Emprestimo emprestimoDevolver = biblioteca.getEmprestimos().stream()
                                .filter(e -> e.getLivro().getISBN().equals(isbnDevolucao) &&
                                        e.getMembro().getId() == idDevolucao)
                                .findFirst()
                                .orElse(null);

                        if (emprestimoDevolver != null) {
                            biblioteca.devolverLivro(emprestimoDevolver);
                        } else {
                            System.out.println("Empréstimo não encontrado!");
                        }
                        break;

                    case 6:
                        System.out.print("Digite o nome do arquivo para salvar: ");
                        String arquivoSalvar = scanner.nextLine();
                        try {
                            biblioteca.salvarDadosEmArquivo(arquivoSalvar);
                            System.out.println("Dados salvos com sucesso!");
                        } catch (IOException e) {
                            System.out.println("Erro ao salvar os dados:");
                            e.printStackTrace();
                        }
                        break;

                    case 7:
                        System.out.print("Digite o nome do arquivo para carregar: ");
                        String arquivoCarregar = scanner.nextLine();
                        try {
                            biblioteca.carregarDadosDeArquivo(arquivoCarregar);
                            System.out.println("Dados carregados com sucesso!");
                        } catch (IOException e) {
                            System.out.println("Erro ao carregar os dados:");
                            e.printStackTrace();
                        }
                        break;

                    case 8:
                        System.out.println("Saindo do sistema. Até logo!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro inesperado no sistema:");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
