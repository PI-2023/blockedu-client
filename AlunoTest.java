import java.time.LocalDate;

public class AlunoTest {
    public static void main(String[] args) {

        Aluno aluno = new Aluno("38511185453", "andrezin rei delas", "andre@rei.delas", LocalDate.of(1500, 1, 1), "82994227242");


        System.out.println("CPF: " + aluno.getCpf());
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Email: " + aluno.getEmail());
        System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
        System.out.println("Telefone Celular: " + aluno.getTelefoneCelular());


        aluno.setCpf("38511185453");
        aluno.setNome("Ciclano");
        aluno.setEmail("ciclano@example.com");
        aluno.setDataNascimento(LocalDate.of(1999, 12, 31));
        aluno.setTelefoneCelular("82994227272");

        System.out.println(aluno.toString());
    }
}