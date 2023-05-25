package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

public class ConexaoBancoDAO {
  private static Dotenv env = Dotenv.load();
  private static Connection conexao = null;
  
  private static final String HOST = "jdbc:mysql://localhost:3306/";
  private static final String SENHA = ConexaoBancoDAO.env.get("DB_PASSWORD", "blockedu");
  private static final String BANCO = ConexaoBancoDAO.HOST + ConexaoBancoDAO.env.get("DB_NAME", "blockedu");
  private static final String USUARIO = ConexaoBancoDAO.env.get("DB_USER", "blockedu");
  
  
  public static Connection getConexao() throws ConexaoBancoDAOException {
    try {
      if (ConexaoBancoDAO.conexao == null) {
        ConexaoBancoDAO.conexao = DriverManager.getConnection(BANCO, USUARIO, SENHA);
      }
      return ConexaoBancoDAO.conexao;        
    } catch (Exception e) {
      throw new ConexaoBancoDAOException(e.getMessage());
    }
  }

  public static Connection getConexao(String banco, String usuario, String senha) throws ConexaoBancoDAOException {
    try {
      String bancoURL = ConexaoBancoDAO.HOST + banco;
      return DriverManager.getConnection(bancoURL, usuario, senha);        
    } catch (Exception e) {
      throw new ConexaoBancoDAOException(e.getMessage());
    }
  }
}
