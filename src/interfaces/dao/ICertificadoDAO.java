package interfaces.dao;

import java.util.List;

import dao.CertificadoDAOException;
import vo.CertificadoVO;

public interface ICertificadoDAO {
  /**
   * Busca todos os certificados da base de dados.
   * @return Uma lista de instâncias de CertificadoVO.
   * @throws CertificadoDAOException
   */
  List<CertificadoVO> buscarTodos() throws CertificadoDAOException;

  /**
   * Registra um novo curso no sistema.
   * @param certificadoVO Instância de CertificadoVO;
   * @throws CertificadoDAOException
   */
  void inserir(CertificadoVO certificadoVO) throws CertificadoDAOException; 

}
