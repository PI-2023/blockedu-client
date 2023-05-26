package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import vo.AlunoVO;

public class AlunoDAO implements IAlunoDAO {
  private Connection conexao;
	
  /**
   * @return Instância de AlunoDAO com conexao padrão.
   */
  public AlunoDAO() throws ConexaoBancoDAOException {
    this.conexao = ConexaoBancoDAO.getConexao();
  }

  /**
   * Construtor com parâmetro de conexao personalizado.
   * @param conexao Instância de conexão do java.sql;
   * @return Instância de AlunoDAO com a conexão passada.
   */
	public AlunoDAO(Connection conexao) {
		this.conexao = conexao;
	}

  @Override
  public AlunoVO buscar(String cpf) throws AlunoDAOException {
    try {
      PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM Aluno WHERE cpf = ?;");
      
      stmt.setString(1, cpf);
      ResultSet rset = stmt.executeQuery();

      if (rset.next()) {
        return criarAlunoVO(rset);
      }
    } catch (Exception e) {
      throw new AlunoDAOException(e.getMessage());
    }

    return null;
  }

  @Override
  public AlunoVO buscar(Integer id) throws AlunoDAOException {
    try {
      PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM Aluno WHERE id = ?;");
      
      stmt.setInt(1, id);
      ResultSet rset = stmt.executeQuery();

      if (rset.next()) {
        return criarAlunoVO(rset);
      }
    } catch (Exception e) {
      throw new AlunoDAOException(e.getMessage());
    }

    return null;
  }

  @Override
  public List<AlunoVO> buscarTodos() throws AlunoDAOException {
    List<AlunoVO> alunos = new ArrayList<>();

    try {
      Statement stmt = this.conexao.createStatement();
      ResultSet rset = stmt.executeQuery("SELECT * FROM Aluno;");

      while (rset.next()) {
        AlunoVO aluno = criarAlunoVO(rset);
        alunos.add(aluno);
      }
    } catch (Exception e) {
      throw new AlunoDAOException(e.getMessage());
    }

    return alunos;
  }

  @Override
  public void inserir(AlunoVO alunoVO) throws AlunoDAOException {
    String query = "INSERT INTO Aluno (cpf, nome, email, data_nascimento, telefone_celular) VALUES (?, ?, ?, ?, ?);";

    try {
      PreparedStatement stmt = this.conexao.prepareStatement(query);
      stmt.setString(1, alunoVO.getCpf());
      stmt.setString(2, alunoVO.getNome());
      stmt.setString(3, alunoVO.getEmail());
      stmt.setDate(4, Date.valueOf(alunoVO.getDataNascimento()));
      stmt.setString(5, alunoVO.getTelefoneCelular());
      stmt.executeUpdate();
    } catch (Exception e) {
      throw new AlunoDAOException(e.getMessage());
    }
  }

  @Override
  public void atualizar(AlunoVO alunoVO) throws AlunoDAOException {
    String query = "UPDATE Aluno SET cpf = ?, nome = ?, email = ?, data_nascimento = ?, telefone_celular = ? WHERE id = ?;";

    try {
      PreparedStatement stmt = this.conexao.prepareStatement(query);
      stmt.setString(1, alunoVO.getCpf());
      stmt.setString(2, alunoVO.getNome());
      stmt.setString(3, alunoVO.getEmail());
      stmt.setDate(4, Date.valueOf(alunoVO.getDataNascimento()));
      stmt.setString(5, alunoVO.getTelefoneCelular());
      stmt.setInt(6, alunoVO.getId());
      stmt.executeUpdate();
    } catch (Exception e) {
      throw new AlunoDAOException(e.getMessage());
    }
  }

  @Override
  public void excluir(String cpf) throws AlunoDAOException {
    try {
      PreparedStatement stmt = this.conexao.prepareStatement("DELETE FROM Aluno WHERE cpf = ?;"); 
      stmt.setString(1, cpf);
      stmt.executeUpdate();
    } catch (Exception e) {
      throw new AlunoDAOException(e.getMessage());
    }
  }

  @Override
  public void excluir(Integer id) throws AlunoDAOException {
    try {
      PreparedStatement stmt = this.conexao.prepareStatement("DELETE FROM Aluno WHERE id = ?;"); 
      stmt.setInt(1, id);
      stmt.executeUpdate();
    } catch (Exception e) {
      throw new AlunoDAOException(e.getMessage());
    }  
  }

  private AlunoVO criarAlunoVO(ResultSet rset) throws SQLException {
    int id = rset.getInt("id");
    String cpf = rset.getString("cpf");
    String nome = rset.getString("nome");
    String email = rset.getString("email");
    String telefoneCelular = rset.getString("telefone_celular");
    LocalDate dataNascimento = rset.getDate("data_nascimento").toLocalDate();
    return new AlunoVO(id, cpf, nome, email, dataNascimento, telefoneCelular);
  }
}
