package src.bo;
import java.util.List;
import java.util.ArrayList;

public class AuthService {
    private List<InstituicaoEnsino> instituicoes;

    public AuthService() {
        this.instituicoes = new ArrayList<>();
    }

    public void adicionarInstituicao(InstituicaoEnsino instituicao) {
        instituicoes.add(instituicao);
    }

    public boolean autenticar(String email, String codigoAcesso) {
        for (InstituicaoEnsino instituicao : instituicoes) {
            if (instituicao.getEmail().equals(email) && instituicao.getCodigoAcesso().equals(codigoAcesso)) {
                return true;
            }
        }
        return false;
    }
}