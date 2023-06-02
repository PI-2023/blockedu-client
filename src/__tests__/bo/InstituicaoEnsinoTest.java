package __tests__.bo;
import org.junit.Test;

import bo.InstituicaoEnsinoBO;

import static org.junit.Assert.*;
public class InstituicaoEnsinoTest {

    @Test
    public void testSetNome() {
        InstituicaoEnsinoBO instituicaoEnsino = new InstituicaoEnsinoBO("IFAL", "ifal@ifal.edu.br", "123456789", "123456789", "123456789");
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
        InstituicaoEnsinoBO instituicaoEnsino = new InstituicaoEnsinoBO("IFAL", "ifal@ifal.edu.br", "123456789", "123456789", "123456789");
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
