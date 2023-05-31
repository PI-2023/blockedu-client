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

import interfaces.dao.ICertificadoDAO;
import vo.CertificadoVO;

public class CertificadoDAO implements ICertificadoDAO {
  private Connection conexao;
	
  /**
   * @return Instância de CertificadoDAO com conexao padrão.
   */
  public CertificadoDAO() throws ConexaoBancoDAOException {
    this.conexao = ConexaoBancoDAO.getConexao();
  }

  /**
   * Construtor com parâmetro de conexao personalizado.
   * @param conexao Instância de conexão do java.sql;
   * @return Instância de CertificadoDAO com a conexão passada.
   */
	public CertificadoDAO(Connection conexao) {
		this.conexao = conexao;
	}

  @Override
  public List<CertificadoVO> buscarTodos() throws CertificadoDAOException {
    List<CertificadoVO> certificados = new ArrayList<>();
    String query = "SELECT * FROM Certificado ORDER BY data_emissao;";

    try {
      Statement stmt = this.conexao.createStatement();
      ResultSet rset = stmt.executeQuery(query);

      while (rset.next()) {
        CertificadoVO certificado = criarCertificadoVO(rset);
        certificados.add(certificado);
      }
    } catch (Exception e) {
      throw new CertificadoDAOException(e.getMessage());
    }
    
    return certificados;
  }

  @Override
  public void inserir(CertificadoVO certificadoVO) throws CertificadoDAOException {
    String query = "INSERT INTO Certificado (data_emissao, assinatura, informacoes_adicionais) VALUES (?, ?, ?)";

    try {
      PreparedStatement stmt = this.conexao.prepareStatement(query);
      stmt.setDate(1, Date.valueOf(certificadoVO.getDataEmissao()));
      stmt.setString(2, certificadoVO.getAssinatura());
      stmt.setString(3, certificadoVO.getInformacoesAdicionais());
      stmt.executeUpdate();
    } catch (Exception e) {
      throw new CertificadoDAOException(e.getMessage());
    }
  }
  
  private CertificadoVO criarCertificadoVO(ResultSet rset) throws SQLException {
    int id = rset.getInt("id");
    LocalDate dataEmissao = rset.getDate("data_emissao").toLocalDate();
    String assinatura = rset.getString("assinatura");
    String informacoesAdicionais = rset.getString("informacoes_adicionais");
    return new CertificadoVO(id, dataEmissao, assinatura, informacoesAdicionais);
  }
}
