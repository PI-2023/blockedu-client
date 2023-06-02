package bo;

import java.util.List;

import dao.ConexaoBancoDAOException;
import dao.CertificadoDAO;
import dao.CertificadoDAOException;
import interfaces.bo.ICertificadoBO;
import vo.AlunoVO;
import vo.CertificadoVO;
import vo.CursoVO;
import vo.InstituicaoEnsinoVO;

public class CertificadoBO implements ICertificadoBO {

  private CertificadoDAO certificadoDAO;
  private InstituicaoEnsinoVO instituicaoVO;

  public CertificadoBO(InstituicaoEnsinoVO instituicao) throws ConexaoBancoDAOException {
    this.instituicaoVO = instituicao;
    this.certificadoDAO = new CertificadoDAO();
  }

  @Override
  public List<CertificadoVO> buscarTodosCertificados() throws CertificadoBOException {
    try {
      return this.certificadoDAO.buscarTodos(this.instituicaoVO);
    } catch (CertificadoDAOException e) {
      throw new CertificadoBOException(e.getMessage());
    }
  }

  @Override
  public void cadastrarCertificado(AlunoVO alunoVO, CursoVO cursoVO, CertificadoVO certificadoVO) throws CertificadoBOException {
    try {
      this.certificadoDAO.inserir(this.instituicaoVO, alunoVO, cursoVO, certificadoVO);
    } catch (CertificadoDAOException e) {
      throw new CertificadoBOException(e.getMessage());
    }
  }
}
