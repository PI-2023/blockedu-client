package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.dao.ICursoDAO;
import vo.CursoVO;
import vo.InstituicaoEnsinoVO;

public class CursoDAO implements ICursoDAO {
  private Connection conexao;
	
  /**
   * @return Instância de CursoDAO com conexao padrão.
   */
  public CursoDAO() throws ConexaoBancoDAOException {
    this.conexao = ConexaoBancoDAO.getConexao();
  }

  /**
   * Construtor com parâmetro de conexao personalizado.
   * @param conexao Instância de conexão do java.sql;
   * @return Instância de CursoDAO com a conexão passada.
   */
	public CursoDAO(Connection conexao) {
		this.conexao = conexao;
	}
  
  @Override
  public List<CursoVO> buscarTodos(InstituicaoEnsinoVO instituicao) throws CursoDAOException {
    List<CursoVO> cursos = new ArrayList<>();
    String query = "SELECT * FROM Curso WHERE instituicao_id = ? ORDER BY nome;";

    try {
      PreparedStatement stmt = this.conexao.prepareStatement(query);
      stmt.setInt(1, instituicao.getId());
      ResultSet rset = stmt.executeQuery(query);

      while (rset.next()) {
        CursoVO curso = criarCursoVO(rset);
        cursos.add(curso);
      }
    } catch (Exception e) {
      throw new CursoDAOException(e.getMessage());
    }
    
    return cursos;
  }

  @Override
  public void inserir(InstituicaoEnsinoVO instituicao, CursoVO cursoVO) throws CursoDAOException {
    String query = "INSERT INTO Curso (nome, descricao, carga_horaria, instituicao_id) VALUES (?, ?, ?, ?);";

    try {
      PreparedStatement stmt = this.conexao.prepareStatement(query);
      stmt.setString(1, cursoVO.getNome());
      stmt.setString(2, cursoVO.getDescricao());
      stmt.setInt(3, cursoVO.getCargaHoraria());
      stmt.setInt(4, instituicao.getId());
      stmt.executeUpdate();
    } catch (Exception e) {
      throw new CursoDAOException(e.getMessage());
    }
  }
  
  private CursoVO criarCursoVO(ResultSet rset) throws SQLException {
    int id = rset.getInt("id");
    String nome = rset.getString("nome");
    String descricao = rset.getString("descricao");
    int cargaHoraria = rset.getInt("carga_horaria");
    return new CursoVO(id, nome, descricao, cargaHoraria);
  }
}
