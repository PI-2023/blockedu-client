package vo;

import java.time.LocalDate;

public class AlunoVO {
  private int id;
  private String cpf;
  private String nome;
  private String email;
  private String telefoneCelular;
  private LocalDate dataNascimento;

  public AlunoVO(int id, String cpf, String nome, String email, LocalDate dataNascimento, String telefoneCelular) {
    this.id = id;
    this.cpf = cpf;
    this.nome = nome;
    this.email = email;
    this.dataNascimento = dataNascimento;
    this.telefoneCelular = telefoneCelular;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
     if (nome.length() < 3) {
      throw new IllegalArgumentException("O campo nome deve ter no mínimo 3 caracteres");
    } else if (nome.length() > 50) {
      throw new IllegalArgumentException("O campo nome deve ter no máximo 50 caracteres");
    }

    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    if (email.length() < 11) {
      throw new IllegalArgumentException("O campo email deve ter no mínimo 11 caracteres");
    } else if (email.length() > 64) {
      throw new IllegalArgumentException("O campo email deve ter no máximo 64 caracteres");
    }

    this.email = email;
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    if (dataNascimento.isAfter(LocalDate.now())) {
      throw new IllegalArgumentException("Data de nascimento inválida");
    } else if (dataNascimento.isBefore(LocalDate.of(1900, 1, 1))) {
      throw new IllegalArgumentException("Data de nascimento inválida");
    }

    this.dataNascimento = dataNascimento;
  }

  public String getTelefoneCelular() {
    return telefoneCelular;
  }

  public void setTelefoneCelular(String telefoneCelular) {
    if (telefoneCelular.length() != 11) {
      throw new IllegalArgumentException("Telefone inválido");
    } else if (telefoneCelular.charAt(2) != '9') {
      throw new IllegalArgumentException("Telefone inválido");
    }

    this.telefoneCelular = telefoneCelular;
  }
}
