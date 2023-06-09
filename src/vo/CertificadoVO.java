package vo;

import java.time.LocalDate;

public class CertificadoVO {
    private int id;
    private LocalDate dataEmissao;
    private String assinatura;
    private String informacoesAdicionais;

    public CertificadoVO(LocalDate dataEmissao, String assinatura, String informacoesAdicionais) {
        this.dataEmissao = dataEmissao;
        this.assinatura = assinatura;
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public CertificadoVO(int id, LocalDate dataEmissao, String assinatura, String informacoesAdicionais) {
        this.id = id;
        this.dataEmissao = dataEmissao;
        this.assinatura = assinatura;
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        if (dataEmissao.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("A data de emissão não pode ser posterior à data atual");
        } else if (dataEmissao.isBefore(LocalDate.of(1900, 1, 1))) {
            throw new IllegalArgumentException("A data de emissão não pode ser anterior à 01/01/1900");
        }

        this.dataEmissao = dataEmissao;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        if (informacoesAdicionais.length() > 300) {
            throw new IllegalArgumentException("O campo informações adicionais deve ter no máximo 300 caracteres");
        }

        this.informacoesAdicionais = informacoesAdicionais;
    }

    /*private void validacaoCertificado (){
        if (dataEmissao.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("A data de emissão não pode ser posterior à data atual");
        } else if (dataEmissao.isBefore(LocalDate.of(1900, 1, 1))) {
            throw new IllegalArgumentException("A data de emissão não pode ser anterior à 01/01/1900");
        }
        if (informacoesAdicionais.length() > 300) {
            throw new IllegalArgumentException("O campo informações adicionais deve ter no máximo 300 caracteres");
        }
    }*/

    /*public void consultarCertificado() {
        System.out.println("Certificado");
        System.out.println();
        System.out.println("dataEmissao= " + dataEmissao);
        System.out.println("assinatura= " + assinatura);
        System.out.println("informacoesAdicionais= " + informacoesAdicionais);

        CertificadoVO certificado = new CertificadoVO(LocalDate.now(), "Assinatura", "Informações adicionais");
        certificado.consultarCertificado();

    }*/

    @Override
    public String toString() {
        return "Certificado\n\n" +
                "dataEmissao= " + dataEmissao + '\n' +
                "assinatura= " + assinatura + '\n' +
                "informacoesAdicionais= " + informacoesAdicionais + '\n';
    }
}

