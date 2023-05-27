package bo;
public class InstituicaoEnsino {
    private String nome;
    private String email;
    private String chavePrimaria;
    private String chavePublica;
    private String codigoAcesso;

    public InstituicaoEnsino(String nome, String email, String chavePrimaria, String chavePublica, String codigoAcesso) {
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
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("Nome da Instituição de ensino está vazio");
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.isEmpty()) {
            throw new IllegalArgumentException("Email da Instituição de ensino está vazio");
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

