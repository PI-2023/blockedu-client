//import org.junit.Test;
//import static org.junit.Assert.*;
//
//public class AuthServiceTest {
//
//    @Test
//    public void testAutenticarComCredenciaisValidas() {
//        AuthService authService = new AuthService();
//
//        InstituicaoEnsino instituicao = new InstituicaoEnsino("Universidade X", "universidadex@example.com", "123456", "public_key", "acesso123");
//        authService.adicionarInstituicao(instituicao);
//
//        assertTrue(authService.autenticar("universidadex@example.com", "acesso123"));
//    }
//
//    @Test
//    public void testAutenticarComCredenciaisInvalidas() {
//        AuthService authService = new AuthService();
//
//        InstituicaoEnsino instituicao = new InstituicaoEnsino("Universidade Y", "universidadey@example.com", "654321", "public_key", "acesso456");
//        authService.adicionarInstituicao(instituicao);
//
//        assertFalse(authService.autenticar("universidadey@example.com", "acesso123"));
//    }
//}