import java.util.List;
import java.util.Scanner;

import bo.CursoBO;
import bo.CursoBOException;
import dao.ConexaoBancoDAOException;
import vo.CursoVO;
import vo.InstituicaoEnsinoVO;

public class CursoView {
  
  private CursoBO cursoBO;
  private Scanner scanner;

  public CursoView(InstituicaoEnsinoVO instituicao) throws ConexaoBancoDAOException {
    this.cursoBO = new CursoBO(instituicao);
    this.scanner = new Scanner(System.in);
  }

  public void exibirMenu() {
    int opcao;
    do {
      System.out.println("----- Menu Cursos -----");
      System.out.println("1. Listar Cursos");
      System.out.println("2. Cadastrar Curso");
      System.out.println("0. Voltar");
      System.out.print("Escolha uma opção: ");
      opcao = scanner.nextInt();
      scanner.nextLine();

      switch (opcao) {
        case 1:
          listarCursos();
          break;
        case 2:
          cadastrarCurso();
          break;
        case 0:
          System.out.println("Voltando ao menu principal...");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  private void listarCursos() {
    try {
      List<CursoVO> cursos = cursoBO.buscarTodosCursos();
      System.out.println("----- Cursos Cadastrados -----");
      for (CursoVO curso : cursos) {
        System.out.println("Nome: " + curso.getNome());
        System.out.println("Carga Horária: " + curso.getCargaHoraria());
        System.out.println("Descrição: " + curso.getDescricao());
        System.out.println("-----------------------------");
      }
    } catch (CursoBOException e) {
      System.out.println("Erro ao buscar cursos: " + e.getMessage());
    }
  }

  private void cadastrarCurso() {
    System.out.println("----- Cadastro de Curso -----");
    
    System.out.print("Nome do Curso: ");
    String nome = scanner.nextLine();
    
    System.out.print("Carga Horária: ");
    int cargaHoraria = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Descrição: ");
    String descricao = scanner.nextLine();

    CursoVO cursoVO = new CursoVO(nome, descricao, cargaHoraria);

    try {
      cursoBO.cadastrarCurso(cursoVO);
      System.out.println("Curso cadastrado com sucesso!");
    } catch (CursoBOException e) {
      System.out.println("Erro ao cadastrar curso: " + e.getMessage());
    }
  }
}
