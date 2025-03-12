import org.junit.Test;
import static org.junit.Assert.*;

public class PratoTest {

    @Test
    public void testCriacaoPrato() {
        Prato prato = new Prato("Hamburguer", 25.90f, "Hamburguer artesanal");

        assertEquals("Hamburguer", prato.getNome());
        assertEquals(25.90f, prato.getPreco(), 0.01);
        assertEquals("Hamburguer artesanal", prato.getDescricao());
    }

    @Test
    public void testToString() {
        Prato prato = new Prato("Salada", 15.50f, "Salada verde com molho especial");
        String expected = "Prato{nome='Salada', preco='15.5', descricao='Salada verde com molho especial'}";
        assertEquals(expected, prato.toString());
    }
}
