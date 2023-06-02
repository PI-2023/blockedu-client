package interfaces.dao;

import java.util.List;

import dao.CertificadoDAOException;
import vo.AlunoVO;
import vo.CertificadoVO;
import vo.CursoVO;
import vo.InstituicaoEnsinoVO;

public interface ICertificadoDAO {
  /**
   * Busca todos os certificados da base de dados.
   * @param instituicaoVO Instância de InstituicaoEnsinoVO;
   * @return Uma lista de instâncias de CertificadoVO.
   * @throws CertificadoDAOException
   */
  List<CertificadoVO> buscarTodos(InstituicaoEnsinoVO instituicaoVO) throws CertificadoDAOException;

  /**
   * Registra um novo curso no sistema.
   * @param insituicaoVO Instância de InstituicaoEnsinoVO;
   * @param AlunoVO Instância de AlunoVO;
   * @param CursoVO Instância de CursoVO;
   * @param certificadoVO Instância de CertificadoVO;
   * @throws CertificadoDAOException
   */
  void inserir(InstituicaoEnsinoVO instituicaoVO, AlunoVO alunoVO, CursoVO cursoVO, CertificadoVO certificadoVO) throws CertificadoDAOException; 

}
