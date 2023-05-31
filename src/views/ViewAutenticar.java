
import java.util.Scanner;

import bo.AuthService;

import java.io.Console;

public class ViewAutenticar {
    Scanner input = new Scanner(System.in);
    Console console = System.console();
    String email;
    String codigoAcesso;

    ViewAutenticar() {
        AuthService autenticacao = new AuthService();
        System.out.println("\033[H\033[2J" + "Para acessar é necessário a autenticação!" +
                "\n*************************************************\n");

        System.out.println("\nInsira seu Email: ");
        this.email = console.readLine();
        //// Chama a função de validaçaõ de Email

        System.out.println("\nInsira sua Senha: ");
        char[] password = console.readPassword();
        this.codigoAcesso = new String(password);

        //// Chama a função de validaçaõ de Email
        if (!(email.equals("")) && !(codigoAcesso.equals(""))) {
            System.out.print("\033[H\033[2J");
            autenticacao.autenticar(email, codigoAcesso);
            System.out.print("Autenticado!");
            String wait = console.readLine();
        }
    }
}
