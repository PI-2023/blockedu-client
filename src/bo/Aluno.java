package bo;
import java.time.LocalDate;

public class Aluno {
    private String cpf;
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private String telefoneCelular;

    public Aluno(String cpf, String nome, String email, LocalDate dataNascimento, String telefoneCelular) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.telefoneCelular = telefoneCelular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
    if (cpf.length() != 11) {
        throw new IllegalArgumentException("CPF inválido");
    }
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        if (telefoneCelular.length() != 11) {
            throw new IllegalArgumentException("Telefone inválido");
        }
        this.telefoneCelular = telefoneCelular;
    }

    @Override
    public String toString() {
        return "Aluno\n\n" +
                "cpf= " + cpf + '\n' +
                "nome= " + nome + '\n' +
                "email= " + email + '\n' +
                "dataNascimento= " + dataNascimento + '\n' +
                "telefoneCelular= " + telefoneCelular + '\n';
    }
}