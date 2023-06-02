package interfaces.bo;

import java.util.List;

import bo.CertificadoBOException;
import vo.AlunoVO;
import vo.CertificadoVO;
import vo.CursoVO;

public interface ICertificadoBO {
  /**
   * Busca todos os alunos referentes à uma instituicao.
   * @return Lista de istâncias de CertificadoVO.
   * @throws CertificadoBOException
   */
  List<CertificadoVO> buscarTodosCertificados() throws CertificadoBOException;
  
  /**
   * Realiza o cadastro de um aluno numa instituição.
   * @param alunoVO Instância de AlunoVO.
   * @param cursoVO Instância de CursoVO.
   * @param certificadoVO Instância de CertificadoVO.
   * @throws CertificadoBOException
   */
  void cadastrarCertificado(AlunoVO alunoVO, CursoVO cursoVO, CertificadoVO certificadoVO) throws CertificadoBOException;
}
