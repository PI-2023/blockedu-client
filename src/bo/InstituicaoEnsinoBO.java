package bo;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import dao.ConexaoBancoDAOException;
import dao.InstituicaoEnsinoDAO;
import dao.InstituicaoEnsinoDAOException;
import interfaces.bo.IInstituicaoEnsinoBO;
import vo.InstituicaoEnsinoVO;

public class InstituicaoEnsinoBO implements IInstituicaoEnsinoBO {
    private static final String CARACTERES_PERMITIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()";
    private InstituicaoEnsinoDAO instituicaoDAO;

    public InstituicaoEnsinoBO() throws ConexaoBancoDAOException {
        this.instituicaoDAO = new InstituicaoEnsinoDAO();
    }

    @Override
    public void cadastrarInstituicao(InstituicaoEnsinoVO instituicaoEnsinoVO) throws InstituicaoEnsinoBOException {
        KeyPair chaves;
        String codigoAcesso = gerarCodigoAcesso();

        try {
            chaves = gerarChavesCriptograficas();
        } catch (NoSuchAlgorithmException e) {
            throw new InstituicaoEnsinoBOException(e.getMessage());
        }
        
        instituicaoEnsinoVO.setChavePrivada(chaves.getPrivate().toString());
        instituicaoEnsinoVO.setChavePublica(chaves.getPublic().toString());
        instituicaoEnsinoVO.setCodigoAcesso(codigoAcesso);

        
        try {
            this.instituicaoDAO.inserir(instituicaoEnsinoVO);
        } catch (InstituicaoEnsinoDAOException e) {
            throw new InstituicaoEnsinoBOException(e.getMessage());
        }
    }


    @Override
    public InstituicaoEnsinoVO buscarInstituicao(String nomeOuEmail) throws InstituicaoEnsinoBOException {
        try {
            return this.instituicaoDAO.buscar(nomeOuEmail);
        } catch (InstituicaoEnsinoDAOException e) {
            throw new InstituicaoEnsinoBOException(e.getMessage());
        }
    }

    @Override
    public boolean autenticarInstituicao(String nomeOuEmail, String codigoAcesso) throws InstituicaoEnsinoBOException {
        InstituicaoEnsinoVO instituicao;
        
        try {
            instituicao = this.instituicaoDAO.buscar(nomeOuEmail);
        } catch (InstituicaoEnsinoDAOException e) {
            throw new InstituicaoEnsinoBOException(e.getMessage());
        }

        if (instituicao != null && instituicao.getCodigoAcesso().equals(codigoAcesso)) {
            return true;
        } else {
            return false;
        }
    }

    private String gerarCodigoAcesso() {
        StringBuilder stringBuilder = new StringBuilder(8);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < 8; i++) {
            int randomIndex = random.nextInt(CARACTERES_PERMITIDOS.length());
            char randomChar = CARACTERES_PERMITIDOS.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

    private KeyPair gerarChavesCriptograficas() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        return keyPairGenerator.genKeyPair();
    }
}

