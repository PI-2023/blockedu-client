package bo;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalDate;
import java.util.List;

import dao.ConexaoBancoDAOException;
import dao.CertificadoDAO;
import dao.CertificadoDAOException;
import so.DocumentSigner;
import vo.AlunoVO;
import vo.CertificadoVO;
import vo.CursoVO;
import vo.InstituicaoEnsinoVO;

public class CertificadoBO  {

  private CertificadoDAO certificadoDAO;
  private InstituicaoEnsinoVO instituicaoVO;
  private DocumentSigner documentSigner;

  public CertificadoBO(InstituicaoEnsinoVO instituicao) throws ConexaoBancoDAOException, NoSuchAlgorithmException, InvalidKeySpecException {
    this.instituicaoVO = instituicao;
    this.certificadoDAO = new CertificadoDAO();
    this.documentSigner = new DocumentSigner();
    this.documentSigner.setPrivateKey(instituicao.getChavePrivada());
  }

  public List<CertificadoVO> buscarTodosCertificados() throws CertificadoBOException {
    try {
      return this.certificadoDAO.buscarTodos(this.instituicaoVO);
    } catch (CertificadoDAOException e) {
      throw new CertificadoBOException(e.getMessage());
    }
  }

  public void cadastrarCertificado(AlunoVO alunoVO, CursoVO cursoVO, String informacoesAdicionais) throws CertificadoBOException {
    try {
      byte[] bytesAssinatura = this.documentSigner.signDocument(informacoesAdicionais.getBytes());
      CertificadoVO certificadoVO = new CertificadoVO(LocalDate.now(), bytesAssinatura.toString(), informacoesAdicionais);
      this.certificadoDAO.inserir(this.instituicaoVO, alunoVO, cursoVO, certificadoVO);
    } catch (Exception e) {
      throw new CertificadoBOException(e.getMessage());
    }
  }


}
