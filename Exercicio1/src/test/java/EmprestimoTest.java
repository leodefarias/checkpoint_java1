import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;

public class EmprestimoTest {

    @Test
    public void testEmprestimo() {
        Livro livro = new Livro("Livro B", "Autor B", "67890");
        Membro membro = new Membro("Beltrano", 3, "beltrano@example.com");
        Date data = new Date();

        Emprestimo emprestimo = new Emprestimo(livro, membro, data);
        assertEquals(livro, emprestimo.getLivro());
        assertEquals(membro, emprestimo.getMembro());
        assertEquals(data, emprestimo.getDataEmprestimo());
    }

    @Test
    public void testToString() {
        Livro livro = new Livro("Livro C", "Autor C", "998877");
        Membro membro = new Membro("Ciclano", 4, "ciclano@example.com");
        Date data = new Date();

        Emprestimo emprestimo = new Emprestimo(livro, membro, data);
        String result = emprestimo.toString();

        assertTrue(result.contains("Livro C"));
        assertTrue(result.contains("Autor C"));
        assertTrue(result.contains("998877"));
        assertTrue(result.contains("Ciclano"));
        assertTrue(result.contains("ciclano@example.com"));
    }
}
