package bo;

import java.util.List;

import dao.ConexaoBancoDAOException;
import dao.CursoDAO;
import dao.CursoDAOException;
import interfaces.bo.ICursoBO;
import vo.CursoVO;
import vo.InstituicaoEnsinoVO;

public class CursoBO implements ICursoBO {

  private CursoDAO cursoDAO;
  private InstituicaoEnsinoVO instituicaoVO;

  public CursoBO(InstituicaoEnsinoVO instituicao) throws ConexaoBancoDAOException {
    this.instituicaoVO = instituicao;
    this.cursoDAO = new CursoDAO();
  }

  @Override
  public List<CursoVO> buscarTodosCursos() throws CursoBOException {
    try {
      return this.cursoDAO.buscarTodos(this.instituicaoVO);
    } catch (CursoDAOException e) {
      throw new CursoBOException(e.getMessage());
    }
  }

  @Override
  public void cadastrarCurso(CursoVO cursoVO) throws CursoBOException {
    try {
      this.cursoDAO.inserir(this.instituicaoVO, cursoVO);
    } catch (CursoDAOException e) {
      throw new CursoBOException(e.getMessage());
    }
  }
}
