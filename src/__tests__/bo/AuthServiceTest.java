package __tests__.bo;
import org.junit.Test;

import bo.AuthService;
import bo.InstituicaoEnsinoBO;

import static org.junit.Assert.*;

public class AuthServiceTest {

    @Test
    public void testAutenticarComCredenciaisValidas() {
        AuthService authService = new AuthService();

        InstituicaoEnsinoBO instituicao = new InstituicaoEnsinoBO("IFAL DO TRAB", "DESGRACA@inferno.com", "123456", "chavezinha", "entra123");
        authService.adicionarInstituicao(instituicao);

        assertTrue(authService.autenticar("DESGRACA@inferno.com", "entra123"));
    }

    @Test
    public void testAutenticarComCredenciaisInvalidas() {
        AuthService authService = new AuthService();

        InstituicaoEnsinoBO instituicao = new InstituicaoEnsinoBO("ufalamentavel", "silvio@vacilao.com", "654321", "chaveteste", "321biscoito");
        authService.adicionarInstituicao(instituicao);

        assertFalse(authService.autenticar("silvio@vacilao.com", "biscoitoerrado"));
    }
}
