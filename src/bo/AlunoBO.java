package bo;

import java.util.List;

import dao.AlunoDAO;
import dao.AlunoDAOException;
import dao.ConexaoBancoDAOException;
import interfaces.bo.IAlunoBO;
import vo.AlunoVO;
import vo.InstituicaoEnsinoVO;

public class AlunoBO implements IAlunoBO {

  private AlunoDAO alunoDAO;
  private InstituicaoEnsinoVO instituicaoVO;

  public AlunoBO(InstituicaoEnsinoVO instituicao) throws ConexaoBancoDAOException {
    this.instituicaoVO = instituicao;
    this.alunoDAO = new AlunoDAO();
  }

  @Override
  public AlunoVO buscarAluno(String cpf) throws AlunoBOException {
    try {
      return this.alunoDAO.buscar(this.instituicaoVO, cpf);
    } catch (AlunoDAOException e) {
      throw new AlunoBOException(e.getMessage());
    }
  }

  @Override
  public List<AlunoVO> buscarTodosAlunos() throws AlunoBOException {
    try {
      return this.alunoDAO.buscarTodos(this.instituicaoVO);
    } catch (AlunoDAOException e) {
      throw new AlunoBOException(e.getMessage());
    }
  }

  @Override
  public void cadastrarAluno(AlunoVO alunoVO) throws AlunoBOException {
    try {
      this.alunoDAO.inserir(this.instituicaoVO, alunoVO);
    } catch (AlunoDAOException e) {
      throw new AlunoBOException(e.getMessage());
    }
  }
}
