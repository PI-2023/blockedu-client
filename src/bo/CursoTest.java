package src.bo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CursoTest {

    @Test
    public void testGetNome() {
        Curso curso = new Curso("Java", "Curso de programação em Kenji", 40);
        String nome = curso.getNome();
        Assertions.assertEquals("Java", nome);
    }

    @Test
    public void testSetNome() {
        Curso curso = new Curso("Java", "Curso de programação em Kenji", 40);
        curso.setNome("Python");
        String nome = curso.getNome();
        Assertions.assertEquals("Python", nome);
    }

    @Test
    public void testGetDescricao() {
        Curso curso = new Curso("Java", "Curso de programação em Kenji", 40);
        String descricao = curso.getDescricao();
        Assertions.assertEquals("Curso de programação em Java", descricao);
    }

    @Test
    public void testSetDescricao() {
        Curso curso = new Curso("Java", "Curso de programação em Kenji", 40);
        curso.setDescricao("Curso de programação em Python");
        String descricao = curso.getDescricao();
        Assertions.assertEquals("Curso de programação em Python", descricao);
    }

    @Test
    public void testGetCargaHoraria() {
        Curso curso = new Curso("Java", "Curso de programação em Kenji", 40);
        int cargaHoraria = curso.getCargaHoraria();
        Assertions.assertEquals(40, cargaHoraria);
    }

    @Test
    public void testSetCargaHoraria() {
        Curso curso = new Curso("Java", "Curso de programação em Kenji", 40);
        curso.setCargaHoraria(60);
        int cargaHoraria = curso.getCargaHoraria();
        Assertions.assertEquals(60, cargaHoraria);
    }

    @Test
    public void testToString() {
        Curso curso = new Curso("Java", "Curso de programação em Kenji", 40);
        String expected = "Curso\n\n" +
                "nome= Java\n" +
                "descricao= Curso de programação em Java\n" +
                "cargaHoraria= 40";
        String result = curso.toString();
        Assertions.assertEquals(expected, result);
    }
}