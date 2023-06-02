import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Scanner;

import bo.AlunoBO;
import bo.CertificadoBO;
import bo.CertificadoBOException;
import bo.CursoBO;
import dao.ConexaoBancoDAOException;
import vo.AlunoVO;
import vo.CertificadoVO;
import vo.CursoVO;
import vo.InstituicaoEnsinoVO;

public class CertificadoView {
  
  private InstituicaoEnsinoVO instituicaoEnsinoVO;
  private CertificadoBO certificadoBO;
  private AlunoBO alunoBO;
  private CursoBO cursoBO;
  private Scanner scanner;

  public CertificadoView(InstituicaoEnsinoVO instituicao) throws ConexaoBancoDAOException, NoSuchAlgorithmException, InvalidKeySpecException {
    this.certificadoBO = new CertificadoBO(instituicao);
    this.alunoBO = new AlunoBO(instituicao);
    this.cursoBO = new CursoBO(instituicao);
    this.scanner = new Scanner(System.in);
  }

  public void exibirMenu() {
    int opcao;
    do {
      System.out.println("----- Menu Certificados -----");
      System.out.println("1. Listar Certificados");
      System.out.println("2. Emitir Certificado");
      System.out.println("0. Voltar");
      System.out.print("Escolha uma opção: ");
      opcao = scanner.nextInt();
      scanner.nextLine(); // Limpar o buffer do scanner

      switch (opcao) {
        case 1:
          listarCertificados();
          break;
        case 2:
          emitirCertificado();
          break;
        case 0:
          System.out.println("Voltando ao menu principal...");
          break;
        default:
          System.out.println("Opção inválida. Tente novamente.");
      }
    } while (opcao != 0);
  }

  private void listarCertificados() {
    try {
      List<CertificadoVO> certificados = certificadoBO.buscarTodosCertificados();
      System.out.println("----- Certificados Emitidos -----");
      for (CertificadoVO certificado : certificados) {
        System.out.println("Assinatura: " + certificado.getAssinatura());
        System.out.println("Data de Emissão: " + certificado.getDataEmissao());
        System.out.println("Informações Adicionais: " + certificado.getInformacoesAdicionais());
        System.out.println("-----------------------------");
      }
    } catch (CertificadoBOException e) {
      System.out.println("Erro ao buscar certificados: " + e.getMessage());
    }
  }

  private void emitirCertificado() {
    System.out.println("----- Emissão de Certificado -----");
    System.out.print("CPF do Aluno: ");
    String cpfAluno = scanner.nextLine();
    System.out.print("ID do Curso: ");
    int idCurso = scanner.nextInt();
    scanner.nextLine();

    
    try {
      AlunoVO alunoVO = alunoBO.buscarAluno(cpfAluno);
      CursoVO cursoVO = cursoBO.buscarCurso(idCurso);
      String infos = "Aluno: " + alunoVO.getNome() + " , Curso:" + cursoVO.getNome() + " , Instituição: " + instituicaoEnsinoVO.getNome();
      certificadoBO.cadastrarCertificado(alunoVO, cursoVO, infos);
      System.out.println("Certificado emitido com sucesso!");
    } catch (Exception e) {
      System.out.println("Erro ao emitir certificado: " + e.getMessage());
    }
  }
}
