public class ViewTeste {
    ViewTeste() {
        Views();
    }

    void Views() {
        System.out.println("\033[H\033[2J" + "Escolha uma das views abaixo:\n" +
                "------------------------------------------------------------------------");
        MenuInterativo menu = new MenuInterativo(
                "Aluno",
                "Curso",
                "Autenticação",
                "Emitir Certificado",
                "Sair");
        int escolha = menu.escolher();
        switch (escolha) {
            case 1:
                System.out.print("\033[H\033[2J");
                new ViewAluno();
                Views();
                break;
            case 2:
                System.out.print("\033[H\033[2J");
                new ViewCursos();
                Views();
                break;
            case 3:
                System.out.print("\033[H\033[2J");
                new ViewAutenticar();
                Views();
                break;
            case 4:
                System.out.print("\033[H\033[2J");
                System.out.println("Em progresso1! \n");
                break;
            case 5:
                System.out.print("\033[H\033[2J");
                System.out.println("Até mais!! \n");
                break;
        }
    }

    public static void main(String args[]) {
        new ViewTeste();
    }
}
