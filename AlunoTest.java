import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class AlunoTest {

    @Test
    public void testSetCpf_InvalidCpf_ThrowsException() {
        String cpf = "1234567890"; // Invalido - 10 digitos
        Aluno aluno = new Aluno("123456789", "João", "joao@teste.com", LocalDate.of(1997, 08, 16), "12345678901");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            aluno.setCpf(cpf);
        });
    }

    @Test
    public void testSetCpf_ValidCpf_SetsCpf() {
        String cpf = "12345678901"; // CPF válido - 11 digitos
        Aluno aluno = new Aluno("12345678901", "João", "joao@teste.com", LocalDate.of(1955, 10, 23), "12345678901");

        aluno.setCpf(cpf);

        Assertions.assertEquals(cpf, aluno.getCpf());
    }

    @Test
    public void testSetTelefoneCelular_InvalidTelefone_ThrowsException() {
        String telefone = "1234567890"; // Telefone inválido - 10 digitos
        Aluno aluno = new Aluno("12345678901", "João", "joao@teste.com", LocalDate.of(1895, 05, 15), "12345678901");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            aluno.setTelefoneCelular(telefone);
        });
    }

    @Test
    public void testSetTelefoneCelular_ValidTelefone_SetsTelefone() {
        String telefone = "12345678901"; // Telefone válido - 11 digitos
        Aluno aluno = new Aluno("12345678901", "João", "joao@teste.com", LocalDate.of(2022, 10, 15), "00000000000");

        aluno.setTelefoneCelular(telefone);

        Assertions.assertEquals(telefone, aluno.getTelefoneCelular());
    }
}