
import java.util.Scanner;

public class ViewCursos {
    Scanner input = new Scanner(System.in);
    Scanner inputN = new Scanner(System.in);

    ViewCursos() {
        view();
    }

    // View
    void view() {
        System.out.println("\033[H\033[2J" + "O Que deseja fazer?\n" +
                "------------------------------------------------------------------------");
        MenuInterativo menu = new MenuInterativo(
                "Cadastrar Curso",
                "Todos os cursos",
                "Cursos abertos",
                "Deletar curso",
                "Voltar");

        int escolha = menu.escolher();
        switch (escolha) {
            case 1:
                cadastrar();
                break;
            case 2:
                System.out.print("\033[H\033[2J");
                cursos();
                break;
            case 3:
                abertos();
                break;
            case 4:
                deletar();
            case 5:
                System.out.print("\033[H\033[2J");
                break;
        }
    }

    //// Cadastrar curso
    void cadastrar() {
        System.out.println("\033[H\033[2J" +"Dados do Curso: \n");
        System.out.println("\nNome: ");
        String nome = input.nextLine();
        System.out.println("\nDescrição: ");
        String descricao = input.nextLine();

        System.out.println("\nCarga Horária:");
        int cargaHoraria = inputN.nextInt();

        if (!(nome.equals("")) && (cargaHoraria > 0) && !(descricao.equals(""))) {
            Curso curso = new Curso(nome, descricao, cargaHoraria);
            System.out.print("\033[H\033[2J");
            System.out.println(curso.toString());
            String wait = input.nextLine();
        }

    }

    // Todos os cursos

    void cursos() {
        System.out.println("Segue abaixo Todos os cursos: (Aperte 0 para voltar) \n");
        int curso = input.nextInt();
        if (curso == 0) {
            System.out.print("\033[H\033[2J");
            view();
        }

    }

    //// cursos com inscrições abertas
    void abertos() {
        System.out.println("Cursos Abertos para inscrições: (Aperte 0 para voltar) \n");
        int curso = input.nextInt();
        if (curso == 0) {
            System.out.print("\033[H\033[2J");
            view();
        }
    }

    // Apagar curso
    void deletar() {
        System.out.println("Cursos Abertos para inscrições: (Aperte 0 para voltar) \n");
        int curso = input.nextInt();
        if (curso == 0) {
            System.out.print("\033[H\033[2J");
            view();
        }
    }
}
