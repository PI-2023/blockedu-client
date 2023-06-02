package interfaces.bo;

import java.util.List;

import bo.AlunoBOException;
import vo.AlunoVO;

public interface IAlunoBO {
  /**
   * Busca aluno da instituição logada no sistema.
   * @param cpf Documento do aluno;
   * @return Instância de AlunoVO.
   * @throws AlunoBOException
   */
  AlunoVO buscarAluno(String cpf) throws AlunoBOException;
  
  /**
   * Busca todos os alunos referentes à uma instituicao.
   * @return Lista de istâncias de AlunoVO.
   * @throws AlunoBOException
   */
  List<AlunoVO> buscarTodosAlunos() throws AlunoBOException;
  
  /**
   * Realiza o cadastro de um aluno numa instituição.
   * @param alunoVO Instância de AlunoVO.
   * @throws AlunoBOException
   */
  void cadastrarAluno(AlunoVO alunoVO) throws AlunoBOException;
}
