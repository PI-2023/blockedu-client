package vo;

public class InstituicaoEnsinoVO {
    private String nome;
    private String email;
    private String chavePrimaria;
    private String chavePublica;
    private String codigoAcesso;

    public InstituicaoEnsinoVO(String nome, String email, String chavePrimaria, String chavePublica, String codigoAcesso) {
        this.nome = nome;
        this.email = email;
        this.chavePrimaria = chavePrimaria;
        this.chavePublica = chavePublica;
        this.codigoAcesso = codigoAcesso;

    }


    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 50) {
            throw new IllegalArgumentException("Nome da instituição de ensino excede 100 caracteres");
        } else if (nome.length() < 10) {
            throw new IllegalArgumentException("Nome da instituição de ensino inferior a 10 caracteres");
        }

        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.length() > 64) {
            throw new IllegalArgumentException("Email da instituição de ensino excede 64 caracteres");
        } else if (email.length() < 11) {
            throw new IllegalArgumentException("Email da instituição de ensino inferior a 11 caracteres");
        } else if (!email.contains("@")) {
            throw new IllegalArgumentException("Email da instituição de ensino não contém @");
        } else if (!email.contains(".")) {
            throw new IllegalArgumentException("Email da instituição de ensino não contém .");
        }

        this.email = email;
    }

    public String getChavePrimaria() {
        return chavePrimaria;
    }

    public void setChavePrimaria(String chavePrimaria) {
        this.chavePrimaria = chavePrimaria;
    }

    public String getChavePublica() {
        return chavePublica;
    }

    public void setChavePublica(String chavePublica) {

        this.chavePublica = chavePublica;
    }

    public String getCodigoAcesso() {
        return codigoAcesso;
    }

    public void setCodigoAcesso(String codigoAcesso) {
        if (codigoAcesso.length() > 8) {
            throw new IllegalArgumentException("Erro, maior que 8 caracteres");
        }

        this.codigoAcesso = codigoAcesso;
    }

    @Override
    public String toString() {
        return "Instituicao de Ensino\n\n" +
                "nome= " + nome + '\n' +
                "email= " + email + '\n' +
                "chavePrimaria= " + chavePrimaria + '\n' +
                "chavePublica= " + chavePublica + '\n' +
                "codigoAcesso= " + codigoAcesso + '\n';
    }

}

