package interfaces.dao;

import java.util.List;

import dao.AlunoDAOException;
import vo.AlunoVO;
import vo.InstituicaoEnsinoVO;

public interface IAlunoDAO {
  /**
   * Busca um aluno na base de dados por cpf.
   * @param cpf Documento de identificação único do aluno;
   * @return Instância de AlunoVO.
   */
  AlunoVO buscar(InstituicaoEnsinoVO insituicao, String cpf) throws AlunoDAOException;

  /**
   * Busca um aluno na base de dados por id.
   * @param id Identificador único do aluno gerado pelo banco;
   * @return Instância de AlunoVO.
   */
  AlunoVO buscar(InstituicaoEnsinoVO insituicao, Integer id) throws AlunoDAOException;
  
  /**
   * Busca todos os alunos cadastrados na base de dados.
   * @return Uma lista de instâncias de AlunoVO.
   */
  List<AlunoVO> buscarTodos(InstituicaoEnsinoVO insituicao) throws AlunoDAOException;
  
  /**
   * Insere um novo aluno na base de dados.
   * @param alunoVO Instância de AlunoVO;
   */
  void inserir(InstituicaoEnsinoVO insituicao, AlunoVO alunoVO) throws AlunoDAOException;
  
  /**
   * Atualiza um aluno na base de dados.
   * @param alunoVO Instância de AlunoVO;
   */
  void atualizar(InstituicaoEnsinoVO insituicao, AlunoVO alunoVO) throws AlunoDAOException;

  /**
   * Exclui um aluno na base de dados por cpf.
   * @param cpf Documento de identificação único do aluno;
   */
  void excluir(InstituicaoEnsinoVO insituicao, String cpf) throws AlunoDAOException;

  /**
   * Exclui um aluno na base de dados por id.
   * @param id Documento de identificação único do aluno;
   */
  void excluir(InstituicaoEnsinoVO insituicao, Integer id) throws AlunoDAOException;
}
