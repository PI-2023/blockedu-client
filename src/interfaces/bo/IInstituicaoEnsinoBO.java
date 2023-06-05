package interfaces.bo;

import bo.InstituicaoEnsinoBOException;
import vo.InstituicaoEnsinoVO;

public interface IInstituicaoEnsinoBO {
  /**
   * Registra uma nova instituicao de ensino no sistema.
   * @param instituicaoEnsinoVO Instância de InstituicaoEnsinoVO;
   * @throws InstituicaoEnsinoBOException
   */
  void cadastrarInstituicao(InstituicaoEnsinoVO instituicaoEnsinoVO) throws InstituicaoEnsinoBOException;

  /**
   * Busca por uma instituicao de ensino no sistema.
   * @param nomeOuEmail nome ou email da instituicao buscada;
   * @return Instância de InstituicaoEnsinoVO.
   * @throws InstituicaoEnsinoBOException
   */
  InstituicaoEnsinoVO buscarInstituicao(String nomeOuEmail) throws InstituicaoEnsinoBOException;

  /**
   * Autentica a instituicao no sistema.
   * @param nomeOuEmail nome ou email da instituicao;
   * @param codigoAcesso codigo de acesso da instituicaop;
   * @return Booleano indicando sucesso ou falha na autenticação;
   * @throws InstituicaoEnsinoBOException
   */
  boolean autenticarInstituicao(String nomeOuEmail, String codigoAcesso) throws InstituicaoEnsinoBOException;
}
