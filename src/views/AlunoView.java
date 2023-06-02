import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import bo.AlunoBO;
import bo.AlunoBOException;
import dao.ConexaoBancoDAOException;
import vo.AlunoVO;
import vo.InstituicaoEnsinoVO;

public class AlunoView {

  private AlunoBO alunoBO;
  private Scanner scanner;

  public AlunoView(InstituicaoEnsinoVO instituicao) throws ConexaoBancoDAOException {
    this.alunoBO = new AlunoBO(instituicao);
    this.scanner = new Scanner(System.in);
  }

  public void cadastrarAluno() {
    try {
      System.out.println("Cadastro de Aluno");
      System.out.println("-----------------");

      System.out.print("CPF: ");
      String cpf = scanner.nextLine();

      System.out.print("Nome: ");
      String nome = scanner.nextLine();

      System.out.print("Email: ");
      String email = scanner.nextLine();

      System.out.print("Data nascimento (formato=AAAA-MM-DD): ");
      String data = scanner.nextLine();
      DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      LocalDate dataNascimento = LocalDate.parse(data, formatacao);

      System.out.print("Telefone Celular: ");
      String telefoneCelular = scanner.nextLine();

      AlunoVO alunoVO = new AlunoVO(cpf, nome, email, dataNascimento, telefoneCelular);
      alunoBO.cadastrarAluno(alunoVO);
      System.out.println("Aluno cadastrado com sucesso!");
    } catch (AlunoBOException e) {
      System.out.println("Erro ao cadastrar o aluno: " + e.getMessage());
    }
  }

  public void listarAlunos() {
    System.out.println("Listagem de Alunos");
    System.out.println("------------------");

    try {
      List<AlunoVO> alunos = alunoBO.buscarTodosAlunos();

      if (alunos.isEmpty()) {
        System.out.println("Nenhum aluno cadastrado.");
      } else {
        for (AlunoVO aluno : alunos) {
          System.out.println("CPF: " + aluno.getCpf());
          System.out.println("Nome: " + aluno.getNome());
          System.out.println("Email: " + aluno.getEmail());
          System.out.println("----------------------");
        }
      }
    } catch (AlunoBOException e) {
      System.out.println("Erro ao listar os alunos: " + e.getMessage());
    }
  }

  public void exibirMenu() {
    int opcao;

    do {
      System.out.println("MENU DE ALUNOS");
      System.out.println("--------------");
      System.out.println("1. Cadastrar Aluno");
      System.out.println("2. Listar Alunos");
      System.out.println("3. Voltar ao Menu da Instituição");
      System.out.print("Opção: ");
      opcao = scanner.nextInt();
      scanner.nextLine(); // Limpar o buffer do scanner

      switch (opcao) {
        case 1:
          cadastrarAluno();
          break;
        case 2:
          listarAlunos();
          break;
        case 3:
          System.out.println("Voltando ao Menu da Instituição...");
          break;
        default:
          System.out.println("Opção inválida.");
          break;
      }

      System.out.println();
    } while (opcao != 3);
  }

}
