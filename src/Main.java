import dao.ConexaoBancoDAOException;

public class Main {
  public static void main(String[] args) throws ConexaoBancoDAOException {
    InstituicaoEnsinoView instituicaoEnsinoView = new InstituicaoEnsinoView();
    instituicaoEnsinoView.exibirMenu();
  }  
}
