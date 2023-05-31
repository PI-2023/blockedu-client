package interfaces.dao;

import dao.InstituicaoEnsinoDAOException;
import vo.InstituicaoEnsinoVO;

public interface IInstituicaoEnsinoDAO {
  /**
   * Busca a instituicao de ensino pelo nome ou email.
   * @return Uma instituicao de ensino.
   * @throws InstituicaoEnsinoDAOException
   */
  InstituicaoEnsinoVO buscar(String nomeOuEmail) throws InstituicaoEnsinoDAOException;

  /**
   * Registra uma nova instituicao de ensino no sistema.
   * @param instituicaoVO Instância de InstituicaoEnsinoVO;
   * @throws InstituicaoEnsinoDAOException
   */
  void inserir(InstituicaoEnsinoVO instituicaoVO) throws InstituicaoEnsinoDAOException; 
}
