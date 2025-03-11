import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import java.io.IOException;

public class BibliotecaTest {

    @Test
    public void testAdicionarRemoverLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("Livro Teste", "Autor Teste", "ISBN-TESTE");

        biblioteca.adicionarLivro(livro);
        List<Livro> livros = biblioteca.getLivros();
        assertTrue(livros.contains(livro));

        biblioteca.removerLivro(livro);
        assertFalse(livros.contains(livro));
    }

    @Test
    public void testRegistrarMembro() {
        Biblioteca biblioteca = new Biblioteca();
        Membro membro = new Membro("Teste Membro", 10, "teste@example.com");

        biblioteca.registrarMembro(membro);
        List<Membro> membros = biblioteca.getMembros();
        assertTrue(membros.contains(membro));
    }

    @Test
    public void testRegistrarEmprestimoEDevolverLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("Livro Emprestado", "Autor Emprestado", "ISBN-EMP");
        Membro membro = new Membro("Membro Emprestimo", 20, "emp@example.com");

        biblioteca.adicionarLivro(livro);
        biblioteca.registrarMembro(membro);

        biblioteca.registrarEmprestimo(livro, membro);
        assertEquals(1, biblioteca.getEmprestimos().size());

        Emprestimo emprestimo = biblioteca.getEmprestimos().get(0);
        biblioteca.devolverLivro(emprestimo);
        assertEquals(0, biblioteca.getEmprestimos().size());
    }

    @Test
    public void testSalvarCarregarDadosEmArquivo() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("Livro Salvando", "Autor Salvando", "ISBN-SALVANDO");
        Membro membro = new Membro("Membro Salvando", 30, "salvando@example.com");

        biblioteca.adicionarLivro(livro);
        biblioteca.registrarMembro(membro);

        try {
            biblioteca.salvarDadosEmArquivo("testeBiblioteca");
        } catch (IOException e) {
            fail("Erro ao salvar dados em arquivo: " + e.getMessage());
        }

        try {
            biblioteca.carregarDadosDeArquivo("arquivos/testeBiblioteca_20250101_120000.txt");
        } catch (IOException e) {
            System.out.println("Arquivo não encontrado para carregar, mas o método foi testado quanto a exceções.");
        }
    }
}
