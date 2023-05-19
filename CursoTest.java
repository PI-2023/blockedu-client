public class CursoTest {
    public static void main(String[] args) {
        // Criando um objeto Curso e definindo seus atributos
        Curso curso = new Curso("Kenji e o Java", "Java orientado a orentiação", 40);

        // Testando os métodos getter
        System.out.println("Nome: " + curso.getNome());
        System.out.println("Descrição: " + curso.getDescricao());
        System.out.println("Carga Horária: " + curso.getCargaHoraria());

        // Testando os métodos setter
        curso.setNome("Inteligência Artificial");
        curso.setDescricao("Tem IA no curso, ctz.");
        curso.setCargaHoraria(30);

        // Imprimindo o objeto curso utilizando o método toString()
        System.out.println(curso.toString());
    }
}