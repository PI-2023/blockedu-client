package dao;

import java.util.List;

import vo.AlunoVO;

public interface IAlunoDAO {
  /**
   * Busca um aluno na base de dados por cpf.
   * @param cpf Documento de identificação único do aluno;
   * @return Instância de AlunoVO.
   */
  AlunoVO buscar(String cpf) throws AlunoDAOException;

  /**
   * Busca um aluno na base de dados por id.
   * @param id Identificador único do aluno gerado pelo banco;
   * @return Instância de AlunoVO.
   */
  AlunoVO buscar(Integer id) throws AlunoDAOException;
  
  /**
   * Busca todos os alunos cadastrados na base de dados.
   * @return Uma lista de instâncias de AlunoVO.
   */
  List<AlunoVO> buscarTodos() throws AlunoDAOException;
  
  /**
   * Insere um novo aluno na base de dados.
   * @param alunoVO Instância de AlunoVO;
   */
  void inserir(AlunoVO alunoVO) throws AlunoDAOException;
  
  /**
   * Atualiza um aluno na base de dados.
   * @param alunoVO Instância de AlunoVO;
   */
  void atualizar(AlunoVO alunoVO) throws AlunoDAOException;

  /**
   * Exclui um aluno na base de dados por cpf.
   * @param cpf Documento de identificação único do aluno;
   */
  void excluir(String cpf) throws AlunoDAOException;

  /**
   * Exclui um aluno na base de dados por id.
   * @param id Documento de identificação único do aluno;
   */
  void excluir(Integer id) throws AlunoDAOException;
}
