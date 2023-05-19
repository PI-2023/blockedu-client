public class CursoTest {
    public static void main(String[] args) {
        Curso curso = new Curso("Kenji e o Java", "Java orientado a orentiação", 40);

        System.out.println("Nome: " + curso.getNome());
        System.out.println("Descrição: " + curso.getDescricao());
        System.out.println("Carga Horária: " + curso.getCargaHoraria());

        curso.setNome("Inteligência Artificial");
        curso.setDescricao("Tem IA no curso, ctz.");
        curso.setCargaHoraria(30);

        System.out.println(curso.toString());
    }
}