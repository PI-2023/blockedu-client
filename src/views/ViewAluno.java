
import java.util.Scanner;
import java.time.LocalDate;

public class ViewAluno {
    Scanner input = new Scanner(System.in);
    Scanner inputN = new Scanner(System.in);

    ViewAluno() {
        view();
    }

    private void view() {
        System.out.println("\033[H\033[2J" + "Olá amigo! Para ir aonde deseja, escolha uma opção Abaixo:\n" +
                "------------------------------------------------------------------------");
        MenuInterativo menu = new MenuInterativo(
                "Cadastrar",
                "Consultar",
                "Atualizar",
                "Deletar",
                "Sair");
        int escolha = menu.escolher();
        switch (escolha) {
            case 1:
                System.out.print("\033[H\033[2J");
                cadastrar();
                break;
            case 2:
                System.out.print("\033[H\033[2J");
                consultar();
                break;
            case 3:
                System.out.print("\033[H\033[2J");
                atualizar();
                break;
            case 4:
                System.out.print("\033[H\033[2J");
                deletar();
                break;
            case 5:
                System.out.print("\033[H\033[2J");
                break;
        }
    }

    //// Cadastrar Aluno
    private void cadastrar() {
        System.out.println("Insira os dados do aluno: \n");

        System.out.println("\nCPF: ");
        String cpf = input.nextLine();

        System.out.println("\nNome completo: ");
        String nome = input.nextLine();

        System.out.println("\nEmail: ");
        String email = input.nextLine();

        System.out.println("\nData de Nascimento: ");

        System.out.println("\nDia:");
        int dia = inputN.nextInt();
        System.out.println("\nMês:");
        int mes = inputN.nextInt();
        System.out.println("\nAno:");
        int ano = inputN.nextInt();

        System.out.println("\nContato: ");
        String contato = input.nextLine();

        if (!(cpf.equals("")) && (dia > 0 && mes > 0 && ano > 0) && !(contato.equals("")) && !(email.equals(""))
                && !(nome.equals(""))) {
            Aluno aluno = new Aluno(cpf, nome, email, LocalDate.of(ano, mes, dia), contato);
            System.out.print("\033[H\033[2J");
            System.out.println(aluno.toString());
            String wait = input.nextLine();
        }

    }

    //// Mostra todos os dados do Aluno
    private void consultar() {
        System.out.println("Consultar será implementado! \n");

    }

    // Cadastra Aluno
    private void deletar() {
        System.out.println("Deletar será implementado! \n");
        int curso = input.nextInt();
        if (curso == 0) {
            System.out.print("\033[H\033[2J");
            view();
        }
    }

    /// Atualiza dados do aluno
    private void atualizar() {
        System.out.println("Atualizar sera implementado: (Aperte 0 para voltar) \n");
        int curso = input.nextInt();
        if (curso == 0) {
            System.out.print("\033[H\033[2J");
            view();
        }
    }
}
