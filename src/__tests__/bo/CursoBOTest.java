package __tests__.bo;
import org.junit.Test;

import vo.CursoVO;

import static org.junit.Assert.*;

public class CursoBOTest {

    @Test
    public void testSetNome(){
        CursoVO curso = new CursoVO("nome", "descricao", 10);
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
        CursoVO curso = new CursoVO("nome", "descricao", 10);
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