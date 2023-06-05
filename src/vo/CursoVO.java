package vo;

public class CursoVO {
    private int id;
    private String nome;
    private String descricao;
    private int cargaHoraria;

    public CursoVO(String nome, String descricao, int cargaHoraria) {
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public CursoVO(int id, String nome, String descricao, int cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() < 3) {
            throw new IllegalArgumentException("O campo nome deve ter no mínimo 3 caracteres");
        } else if (nome.length() > 50) {
            throw new IllegalArgumentException("O campo nome deve ter no máximo 50 caracteres");
        }

        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao.length() < 10) {
            throw new IllegalArgumentException("O campo descrição deve ter no mínimo 10 caracteres");
        } else if (descricao.length() > 300) {
            throw new IllegalArgumentException("O campo descrição deve ter no máximo 300 caracteres");
        }

        this.descricao = descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
    if (cargaHoraria < 4) {
            throw new IllegalArgumentException("O campo carga horária deve ser maior que 4");
        }

        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso\n\n" +
                "nome= " + nome + '\n' +
                "descricao= " + descricao + '\n' +
                "cargaHoraria= " + cargaHoraria;
    }

}
