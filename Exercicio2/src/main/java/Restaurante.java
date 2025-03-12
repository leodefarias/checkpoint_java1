import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Restaurante {
    private List<Prato> cardapio = new ArrayList<>();
    private List<Pedido> pedidos = new ArrayList<>();

    public List<Prato> getCardapio() {
        return cardapio;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void adicionarPratoAoCardapio(Prato prato) {
        cardapio.add(prato);
        System.out.println("Prato adicionado ao cardápio: " + prato);
    }

    public void removerPratoDoCardapio(String nomePrato) {
        cardapio.removeIf(prato -> prato.getNome().equalsIgnoreCase(nomePrato));
        System.out.println("Prato removido do cardápio: " + nomePrato);
    }

    public Pedido criarPedido(String cliente, List<Prato> pratos) {
        int numeroPedido = pedidos.size() + 1;
        float total = 0;
        String[] listaDePratos = new String[pratos.size()];

        for (int i = 0; i < pratos.size(); i++) {
            listaDePratos[i] = pratos.get(i).getNome();
            total += pratos.get(i).getPreco();
        }

        Pedido pedido = new Pedido(numeroPedido, cliente, listaDePratos, total);
        pedidos.add(pedido);
        System.out.println("Pedido criado: " + pedido);
        return pedido;
    }

    public void visualizarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }

    public void salvarDadosEmArquivo(String baseNomeArquivo) {
        BufferedWriter writer = null;
        try {
            File pasta = new File("arquivos");
            if (!pasta.exists()) {
                pasta.mkdir();
            }

            String dataAtual = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String nomeArquivo = "arquivos/" + baseNomeArquivo + "_" + dataAtual + ".txt";

            writer = new BufferedWriter(new FileWriter(nomeArquivo));
            for (Prato prato : cardapio) {
                writer.write("Prato:" + prato + "\n");
            }
            for (Pedido pedido : pedidos) {
                writer.write("Pedido:" + pedido + "\n");
            }
            System.out.println("Dados salvos com sucesso no arquivo: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados em arquivo (IOException):");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro inesperado ao salvar dados:");
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                    System.out.println("Arquivo fechado com sucesso.");
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o recurso de escrita (BufferedWriter):");
                    e.printStackTrace();
                }
            }
        }
    }

    public void carregarDadosDeArquivo(String nomeArquivo) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados do arquivo (IOException):");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro inesperado ao carregar dados:");
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    System.out.println("Leitura finalizada e recurso fechado com sucesso.");
                } catch (IOException e) {
                    System.out.println("Erro ao fechar o arquivo (IOException):");
                    e.printStackTrace();
                }
            }
        }
    }
}
