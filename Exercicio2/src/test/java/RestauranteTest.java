import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import java.io.IOException;

public class RestauranteTest {

    @Test
    public void testAdicionarRemoverPrato() {
        Restaurante restaurante = new Restaurante();
        Prato prato = new Prato("Pizza", 29.90f, "Pizza de Calabresa");

        restaurante.adicionarPratoAoCardapio(prato);
        assertTrue(restaurante.getCardapio().contains(prato));

        restaurante.removerPratoDoCardapio("Pizza");
        assertFalse(restaurante.getCardapio().contains(prato));
    }

    @Test
    public void testCriarPedido() {
        Restaurante restaurante = new Restaurante();
        Prato prato = new Prato("Lasanha", 35.50f, "Lasanha de queijo");
        restaurante.adicionarPratoAoCardapio(prato);

        List<Prato> pratosPedido = new ArrayList<>();
        pratosPedido.add(prato);

        Pedido pedido = restaurante.criarPedido("Carlos", pratosPedido);
        assertEquals(1, restaurante.getPedidos().size());
        assertEquals("Carlos", pedido.getCliente());
        assertEquals(35.50f, pedido.getTotal(), 0.01);
    }

    @Test
    public void testSalvarCarregarDados() {
        Restaurante restaurante = new Restaurante();
        Prato prato = new Prato("Sushi", 55.00f, "Sushi variado");
        restaurante.adicionarPratoAoCardapio(prato);

        restaurante.salvarDadosEmArquivo("testeRestaurante");

        restaurante.carregarDadosDeArquivo("arquivos/testeRestaurante_20250101_120000.txt");
    }
}
