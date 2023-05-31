package interfaces.dao;

import java.util.List;

import dao.CursoDAOException;
import vo.CursoVO;

public interface ICursoDAO {
  /**
   * Busca todos os cursos da base de dados.
   * @return Uma lista de instâncias de AlunoVO.
   * @throws CursoDAOException
   */
  List<CursoVO> buscarTodos() throws CursoDAOException;

  /**
   * Registra um novo curso no sistema.
   * @param cursoVO Instância de CursoVO;
   * @throws CursoDAOException
   */
  void inserir(CursoVO cursoVO) throws CursoDAOException; 
}
