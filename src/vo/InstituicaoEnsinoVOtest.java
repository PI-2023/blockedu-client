package vo;
import org.junit.Test;
import static org.junit.Assert.*;

public class InstituicaoEnsinoVOtest {

    @Test
    public void testSetNome() {
        InstituicaoEnsinoVO instituicaoEnsino = new InstituicaoEnsinoVO("IFAL", "ifal@ifal.edu.br", "123456789", "123456789", "123456789");
        instituicaoEnsino.setNome("IFAL");
        assert instituicaoEnsino.getNome().equals("Instituto Federal de Alagoas");

        try {
            instituicaoEnsino.setNome("IFALZIN");
            fail("Deveria ter lançado exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Nome da Instituição de ensino não deve haver menos de 10 caracteres", e.getMessage());
        }

        try {
            instituicaoEnsino.setNome("Instituto federal de ensino de ciencias, informatica, biologia, hotelaria, matematica, fisica, quimica, geografia, ingles, religiao, historia, portugues, filosofia, sociologia, artes, reação, espanhol, frances, italiano, germanico, japones, chines, coreano, russo, arabe, hebraico, grego, latim, astronomia, astrologia, fisica quantica, fisica nuclear, fisica de particulas, fisica de atomos, fisica de moleculas, fisica de corpos, fisica de objetos, fisica de coisas, fisica de materia, fisica de energia, fisica de forças, fisica de movimento, fisica de velocidade, fisica de aceleração, fisica de desaceleração, fisica de deslocamento, fisica de deslocamento angular, fisica de deslocamento linear, fisica de deslocamento vertical, fisica de deslocamento horizontal, fisica de deslocamento diagonal, fisica de deslocamento transversal, fisica de deslocamento rotacional, fisica de deslocamento translação");
            fail("Deveria ter lançado exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Nome da Instituição de ensino não deve haver mais de 100 caracteres", e.getMessage());
        }

    }

    @Test
    public void testSetEmail() {
        InstituicaoEnsinoVO instituicaoEnsino = new InstituicaoEnsinoVO("IFAL", "ifal@ifal.edu.br", "123456789", "123456789", "123456789");
        instituicaoEnsino.setEmail("ifal@ifal.edu.br");
        assertEquals("ifal@ifal.edu.br", instituicaoEnsino.getEmail());

        try {
            instituicaoEnsino.setEmail("ifal");
            fail("Deveria ter lançado exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Email da Instituição de ensino deve conter @ e .", e.getMessage());
        }

        try {
            instituicaoEnsino.setEmail("ifal@");
            fail("Deveria ter lançado exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Email da Instituição de ensino deve conter @ e .", e.getMessage());
        }

        try {
            instituicaoEnsino.setEmail("@ifal.com");
            fail("Deveria ter lançado exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Email da Instituição de ensino deve conter deve conter pelo menos 11 caracteres", e.getMessage());
        }

        try {
            instituicaoEnsino.setEmail("ifal.com");
            fail("Deveria ter lançado exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Email da Instituição de ensino deve conter @ e .", e.getMessage());
        }

        try {
            instituicaoEnsino.setEmail("ifalinstitutofederaldealagoasifaldobrasilifaldemaceioifaldealagoasifalifalifalmuitoifalsomostodosifal@ifal.com");
            fail("Deveria ter lançado exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("Email da Instituição de ensino não deve exceder 64 caracteres", e.getMessage());
        }
    }
}


