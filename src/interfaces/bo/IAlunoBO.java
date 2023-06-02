package interfaces.bo;

import java.util.List;

import bo.AlunoBOException;
import vo.AlunoVO;

public interface IAlunoBO {
  /**
   * Busca aluno da instituição logada no sistema.
   * @param instituicaoId Identificador da instituição;
   * @param cpf Documento do aluno;
   * @return Instância de AlunoVO.
   * @throws AlunoBOException
   */
  AlunoVO buscarAluno(int instituicaoId, String cpf) throws AlunoBOException;
  
  /**
   * Busca todos os alunos referentes à uma instituicao.
   * @param instituicaoId Identificador da instituição;
   * @return Lista de istâncias de AlunoVO.
   * @throws AlunoBOException
   */
  List<AlunoVO> buscarTodosAlunos(int instituicaoId) throws AlunoBOException;
  
  /**
   * Realiza o cadastro de um aluno numa instituição.
   * @param instituicaoId Identificador da instituição;
   * @param alunoVO Instância de AlunoVO.
   * @throws AlunoBOException
   */
  void cadastrarAluno(int instituicaoId, AlunoVO alunoVO) throws AlunoBOException;
}
