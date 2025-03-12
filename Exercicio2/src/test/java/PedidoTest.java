import org.junit.Test;
import static org.junit.Assert.*;

public class PedidoTest {

    @Test
    public void testCriacaoPedido() {
        String[] pratos = {"Pizza", "Lasanha"};
        Pedido pedido = new Pedido(1, "Ana", pratos, 59.80f);

        assertEquals(1, pedido.getNumeroPedido());
        assertEquals("Ana", pedido.getCliente());
        assertArrayEquals(pratos, pedido.getListaDePratos());
        assertEquals(59.80f, pedido.getTotal(), 0.01);
    }

    @Test
    public void testToString() {
        String[] pratos = {"Sushi", "Temaki"};
        Pedido pedido = new Pedido(2, "Bruno", pratos, 85.00f);
        String result = pedido.toString();

        assertTrue(result.contains("Sushi"));
        assertTrue(result.contains("Temaki"));
        assertTrue(result.contains("Bruno"));
        assertTrue(result.contains("85.0"));
    }
}
