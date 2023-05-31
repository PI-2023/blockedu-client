package vo;

public class InstituicaoEnsinoVO {
    private int id;
    private String nome;
    private String email;
    private String chavePrivada;
    private String chavePublica;
    private String codigoAcesso;

    public InstituicaoEnsinoVO(String nome, String email, String chavePrivada, String chavePublica, String codigoAcesso) {
        this.nome = nome;
        this.email = email;
        this.chavePrivada = chavePrivada;
        this.chavePublica = chavePublica;
        this.codigoAcesso = codigoAcesso;
    }

    public InstituicaoEnsinoVO(int id, String nome, String email, String chavePrivada, String chavePublica, String codigoAcesso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.chavePrivada = chavePrivada;
        this.chavePublica = chavePublica;
        this.codigoAcesso = codigoAcesso;
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

    public String getChavePrivada() {
        return chavePrivada;
    }

    public void setChavePrivada(String chavePrivada) {
        this.chavePrivada = chavePrivada;
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
                "chavePrivada= " + chavePrivada + '\n' +
                "chavePublica= " + chavePublica + '\n' +
                "codigoAcesso= " + codigoAcesso + '\n';
    }

}

