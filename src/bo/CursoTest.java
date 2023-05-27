package bo;
import org.junit.Test;
import static org.junit.Assert.*;

public class CursoTest {

    @Test
    public void testSetNome(){
        Curso curso = new Curso("nome", "descricao", 10);
        curso.setNome("nome");
        assertEquals("nome", curso.getNome());

        try {
            curso.setNome("");
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo nome está vazio", e.getMessage());
        }
    }

    @Test
    public void testSetDescricao(){
        Curso curso = new Curso("nome", "descricao", 10);
        curso.setDescricao("descricao");
        assertEquals("descricao", curso.getDescricao());

        try {
            curso.setDescricao("");
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo descrição está vazio", e.getMessage());
        }
    }

}