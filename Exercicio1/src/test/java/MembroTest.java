import org.junit.Test;
import static org.junit.Assert.*;

public class MembroTest {

    @Test
    public void testMembro() {
        Membro membro = new Membro("Fulano de Tal", 1, "fulano@example.com");
        assertEquals("Fulano de Tal", membro.getNome());
        assertEquals(1, membro.getId());
        assertEquals("fulano@example.com", membro.getEmail());
    }

    @Test
    public void testToString() {
        Membro membro = new Membro("Fulano de Tal", 2, "fulano2@example.com");
        String expected = "Membro{nome='Fulano de Tal', id=2, email='fulano2@example.com'}";
        assertEquals(expected, membro.toString());
    }
}
