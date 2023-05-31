package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.dao.IInstituicaoEnsinoDAO;
import vo.InstituicaoEnsinoVO;

public class InstituicaoEnsinoDAO implements IInstituicaoEnsinoDAO {
  private Connection conexao;

  /**
   * @return Instância de InstituicaoEnsinoDAO com conexao padrão.
   */
  public InstituicaoEnsinoDAO() throws ConexaoBancoDAOException {
    this.conexao = ConexaoBancoDAO.getConexao();
  }

  /**
   * Construtor com parâmetro de conexao personalizado.
   * @param conexao Instância de conexão do java.sql;
   * @return Instância de InstituicaoEnsinoDAO com a conexão passada.
   */
	public InstituicaoEnsinoDAO(Connection conexao) {
		this.conexao = conexao;
	}

  @Override
  public InstituicaoEnsinoVO buscar(String nomeOuEmail) throws InstituicaoEnsinoDAOException {
    String query = "SELECT * FROM InsituicaoEnsino WHERE nome = ? OR email = ? LIMIT 1;";

    try {
      PreparedStatement stmt = this.conexao.prepareStatement(query);
      stmt.setString(1, nomeOuEmail);
      stmt.setString(2, nomeOuEmail);
      ResultSet rset = stmt.executeQuery();

      if (rset.next()) {
        InstituicaoEnsinoVO instituicaoVO = criarInstituicaoEnsinoVO(rset);
        return instituicaoVO;
      }
    } catch (Exception e) {
      throw new InstituicaoEnsinoDAOException(e.getMessage());
    }

    return null;
  }

  @Override
  public void inserir(InstituicaoEnsinoVO instituicaoVO) throws InstituicaoEnsinoDAOException {
    String query = "INSERT INTO IntituicaoEnsino (nome, email, chave_privada, chave_publica, codigo_acesso) VALUES (?, ?, ?, ?, ?);";

    try {
      PreparedStatement stmt = this.conexao.prepareStatement(query);
      stmt.setString(1, instituicaoVO.getNome());
      stmt.setString(2, instituicaoVO.getEmail());
      stmt.setString(3, instituicaoVO.getChavePrivada());
      stmt.setString(4, instituicaoVO.getChavePublica());
      stmt.setString(5, instituicaoVO.getCodigoAcesso());
      stmt.executeUpdate();
    } catch (Exception e) {
      throw new InstituicaoEnsinoDAOException(e.getMessage());
    }
  }

  private InstituicaoEnsinoVO criarInstituicaoEnsinoVO(ResultSet rset) throws SQLException {
    int id = rset.getInt("id");
    String nome = rset.getString("nome");
    String email = rset.getString("email");
    String chavePrivada = rset.getString("chave_privada");
    String chavePublica = rset.getString("chave_publica");
    String codigoAcesso = rset.getString("codigo_acesso");
    return new InstituicaoEnsinoVO(id, nome, email, chavePrivada, chavePublica, codigoAcesso);
  }
}
