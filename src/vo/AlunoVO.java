package vo;

import java.time.LocalDate;

public class AlunoVO {
  private String cpf;
  private String nome;
  private String email;
  private String telefoneCelular;
  private LocalDate dataNascimento;

  public AlunoVO(String cpf, String nome, String email, LocalDate dataNascimento, String telefoneCelular) {
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
    this.telefoneCelular = telefoneCelular;
  }
}