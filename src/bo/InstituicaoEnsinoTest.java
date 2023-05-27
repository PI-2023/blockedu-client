package bo;
import org.junit.Test;
import static org.junit.Assert.*;
public class InstituicaoEnsinoTest {

    @Test
    public void testSetNome() {
        InstituicaoEnsino instituicaoEnsino = new InstituicaoEnsino("IFAL", "ifal@ifal.edu.br", "123456789", "123456789", "123456789");
        instituicaoEnsino.setNome("IFAL");
        assertEquals("IFAL", instituicaoEnsino.getNome());

        try {
            instituicaoEnsino.setNome("");
            fail("Deveria ter lançado exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Nome da Instituição de ensino está vazio", e.getMessage());
        }

    }

    @Test
    public void testSetEmail() {
        InstituicaoEnsino instituicaoEnsino = new InstituicaoEnsino("IFAL", "ifal@ifal.edu.br", "123456789", "123456789", "123456789");
        instituicaoEnsino.setEmail("ifal@ifal.edu.br");
        assertEquals("ifal@ifal.edu.br", instituicaoEnsino.getEmail());

        try {
            instituicaoEnsino.setEmail("");
            fail("Deveria ter lançado exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Email da Instituição de ensino está vazio", e.getMessage());
        }
    }
}