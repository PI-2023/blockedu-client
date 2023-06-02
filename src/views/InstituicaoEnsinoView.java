import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Scanner;

import bo.InstituicaoEnsinoBO;
import bo.InstituicaoEnsinoBOException;
import dao.ConexaoBancoDAOException;
import vo.InstituicaoEnsinoVO;

public class InstituicaoEnsinoView {

  private InstituicaoEnsinoBO instituicaoBO;
  private Scanner scanner;

  public InstituicaoEnsinoView() throws ConexaoBancoDAOException {
    this.instituicaoBO = new InstituicaoEnsinoBO();
    this.scanner = new Scanner(System.in);
  }

  public void exibirMenu() throws ConexaoBancoDAOException {
    int opcao;
    do {
      System.out.println("Bem-vindo ao Blockedu - Sistema de Certificados!");
      System.out.println("1 - Login");
      System.out.println("2 - Cadastro");
      System.out.println("0 - Sair");
      System.out.print("Escolha uma opção: ");
      opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1:
          autenticar();
          break;
        case 2:
          cadastrarInstituicao();
          break;
        case 0:
          System.out.println("Encerrando programa...");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  private void cadastrarInstituicao() {
    System.out.println("----- Cadastro de Instituição -----");
    System.out.print("Nome: ");
    String nome = scanner.nextLine();
    System.out.print("Email: ");
    String email = scanner.nextLine();

    InstituicaoEnsinoVO instituicaoVO = new InstituicaoEnsinoVO(nome, email);

    try {
      instituicaoBO.cadastrarInstituicao(instituicaoVO);
      InstituicaoEnsinoVO instituicaoCriada = instituicaoBO.buscarInstituicao(email);
      System.out.println("Instituição cadastrada com sucesso!");
      System.out.println("Seu código de acesso foi gerado: " + instituicaoCriada.getCodigoAcesso());
    } catch (InstituicaoEnsinoBOException e) {
      System.out.println("Erro ao cadastrar instituição: " + e.getMessage());
    }
  }

  private void autenticar() throws ConexaoBancoDAOException {
    System.out.println("----- Autenticação de Instituição -----");
    System.out.print("Email: ");
    String email = scanner.nextLine();
    System.out.print("Código Acesso: ");
    String codigoAcesso = scanner.nextLine();

    try {
      boolean autenticado = instituicaoBO.autenticarInstituicao(email, codigoAcesso);
      if (autenticado) {
        System.out.println("Autenticação realizada com sucesso!");
        InstituicaoEnsinoVO instituicaoVO = instituicaoBO.buscarInstituicao(email);
        exibirMenuPrincipal(instituicaoVO);
      } else {
        System.out.println("Email ou senha inválidos. Tente novamente.");
      }
    } catch (Exception e) {
      System.out.println("Erro ao autenticar instituição: " + e.getMessage());
    }
  }

  private void exibirMenuPrincipal(InstituicaoEnsinoVO instituicao) throws ConexaoBancoDAOException, NoSuchAlgorithmException, InvalidKeySpecException {
    AlunoView alunoView = new AlunoView(instituicao);
    CursoView cursoView = new CursoView(instituicao);
    CertificadoView certificadoView = new CertificadoView(instituicao);

    int opcao;
    do {
      System.out.println("----- Menu Principal -----");
      System.out.println("1. Gerenciar Alunos");
      System.out.println("2. Gerenciar Cursos");
      System.out.println("3. Gerenciar Certificados");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");
      opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1:
          alunoView.exibirMenu();
          break;
        case 2:
          cursoView.exibirMenu();
          break;
        case 3:
          certificadoView.exibirMenu();
          break;
        case 0:
          System.out.println("Encerrando sessão...");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }
}
