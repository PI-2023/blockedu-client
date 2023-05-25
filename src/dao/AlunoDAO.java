package dao;

import java.sql.Connection;
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
  public AlunoVO buscar(String cpf) {
    // Não implementado
    throw new UnsupportedOperationException("Método 'buscar' não implementado");
  }

  @Override
  public AlunoVO buscar(Integer id) {
    // Não implementado
    throw new UnsupportedOperationException("Método 'buscar' não implementado");
  }

  @Override
  public List<AlunoVO> buscarTodos() {
    // Não implementado
    throw new UnsupportedOperationException("Método 'buscarTodos' não implementado");
  }

  @Override
  public void inserir(AlunoVO alunoVO) {
    // Não implementado
    throw new UnsupportedOperationException("Método 'inserir' não implementado");
  }

  @Override
  public void atualizar(AlunoVO alunoVO) {
    // Não implementado
    throw new UnsupportedOperationException("Método 'atualizar' não implementado");
  }

  @Override
  public void excluir(String cpf) {
    // Não implementado
    throw new UnsupportedOperationException("Método 'excluir' não implementado");
  }

  @Override
  public void excluir(Integer id) {
    // Não implementado
    throw new UnsupportedOperationException("Método 'excluir' não implementado");
  }

}
