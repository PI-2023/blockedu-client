import java.util.Scanner;

public class MenuInterativo {
  String[] escolhas;
  // int setPosition = 0;
  Scanner input = new Scanner(System.in);

  public MenuInterativo(String... listaDeEscolhas) {
    this.escolhas = listaDeEscolhas;
  }

  int escolher() {
    for (int i = 0; i < escolhas.length; i++) {
        System.out.println("\n" + (i + 1) + "- " + escolhas[i]);
    }
    ;
    int resultado = input.nextInt();
    if (resultado <= 0 || resultado > escolhas.length) {
        System.out.println("\033[H\033[2J" + "Valor Invalido! Realize outra escolha: \n" +
                "------------------------------------------------------------------------");
        resultado = escolher();
    }
    System.out.println("\033[H\033[2J");
    System.out.println(resultado);
    return resultado;
  }
}