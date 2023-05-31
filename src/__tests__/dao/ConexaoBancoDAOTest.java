package __tests__.dao;

import org.junit.Test;

import dao.ConexaoBancoDAO;
import dao.ConexaoBancoDAOException;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;


public class ConexaoBancoDAOTest {

  private static final String BANCO = "null";
  private static final String SENHA = "null";
  private static final String USUARIO = "null";

  @Test
  public void deveEstabelecerConexao() throws ConexaoBancoDAOException {
    try {
      Connection conexao = ConexaoBancoDAO.getConexao();
      assertNotNull(conexao);
    } catch (ConexaoBancoDAOException e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void naoDeveEstabelecerConexao() throws ConexaoBancoDAOException {
    assertThrows(ConexaoBancoDAOException.class, () -> ConexaoBancoDAO.getConexao(BANCO, USUARIO, SENHA));
  }
}
