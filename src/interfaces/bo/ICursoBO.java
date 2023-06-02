package interfaces.bo;

import java.util.List;

import bo.CursoBOException;
import vo.CursoVO;

public interface ICursoBO {
  /**
   * Busca todos os alunos referentes à uma instituicao.
   * @return Lista de istâncias de CursoVO.
   * @throws CursoBOException
   */
  List<CursoVO> buscarTodosCursos() throws CursoBOException;
  
  /**
   * Realiza o cadastro de um aluno numa instituição.
   * @param cursoVO Instância de CursoVO.
   * @throws CursoBOException
   */
  void cadastrarCurso(CursoVO cursoVO) throws CursoBOException;
}
