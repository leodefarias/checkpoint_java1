import java.io.*;
import java.util.*;

public class SistemaRestaurante {
    public static void main(String[] args) {
        Restaurante restaurante = new Restaurante();
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.println("\n--- Sistema Restaurante ---");
                System.out.println("1. Adicionar Prato ao Cardápio");
                System.out.println("2. Remover Prato do Cardápio");
                System.out.println("3. Criar Pedido");
                System.out.println("4. Visualizar Pedidos");
                System.out.println("5. Salvar Dados em Arquivo");
                System.out.println("6. Carregar Dados do Arquivo");
                System.out.println("7. Sair");
                System.out.print("Escolha uma opção: ");

                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.print("Nome do prato: ");
                        String nomePrato = scanner.nextLine();
                        System.out.print("Preço do prato: ");
                        float precoPrato = scanner.nextFloat();
                        scanner.nextLine();
                        System.out.print("Descrição do prato: ");
                        String descricaoPrato = scanner.nextLine();
                        restaurante.adicionarPratoAoCardapio(new Prato(nomePrato, precoPrato, descricaoPrato));
                        break;

                    case 2:
                        System.out.print("Nome do prato a remover: ");
                        String nomeRemover = scanner.nextLine();
                        restaurante.removerPratoDoCardapio(nomeRemover);
                        break;

                    case 3:
                        System.out.print("Nome do cliente: ");
                        String nomeCliente = scanner.nextLine();
                        List<Prato> pratosPedido = new ArrayList<>();
                        while (true) {
                            System.out.print("Digite o nome do prato para adicionar ao pedido (ou 'sair' para finalizar): ");
                            String nomePratoPedido = scanner.nextLine();
                            if (nomePratoPedido.equalsIgnoreCase("sair")) {
                                break;
                            }
                            for (Prato prato : restaurante.getCardapio()) {
                                if (prato.getNome().equalsIgnoreCase(nomePratoPedido)) {
                                    pratosPedido.add(prato);
                                    System.out.println("Prato adicionado ao pedido.");
                                    break;
                                }
                            }
                        }
                        restaurante.criarPedido(nomeCliente, pratosPedido);
                        break;

                    case 4:
                        restaurante.visualizarPedidos();
                        break;

                    case 5:
                        System.out.print("Digite o nome do arquivo para salvar: ");
                        String arquivoSalvar = scanner.nextLine();
                        try {
                            restaurante.salvarDadosEmArquivo(arquivoSalvar);
                            System.out.println("Dados salvos com sucesso!");
                        } catch (Exception e) {
                            System.out.println("Erro ao salvar os dados:");
                            e.printStackTrace();
                        }
                        break;

                    case 6:
                        System.out.print("Digite o nome do arquivo para carregar: ");
                        String arquivoCarregar = scanner.nextLine();
                        try {
                            restaurante.carregarDadosDeArquivo(arquivoCarregar);
                            System.out.println("Dados carregados com sucesso!");
                        } catch (Exception e) {
                            System.out.println("Erro ao carregar os dados:");
                            e.printStackTrace();
                        }
                        break;

                    case 7:
                        System.out.println("Saindo do sistema. Até logo!");
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