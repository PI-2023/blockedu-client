package vo;

import java.time.LocalDate;

public class CertificadoVO {
    private LocalDate dataEmissao;
    private String assinatura;
    private String informacoesAdicionais;

    public CertificadoVO(LocalDate dataEmissao, String assinatura, String informacoesAdicionais) {
        this.dataEmissao = dataEmissao;
        this.assinatura = assinatura;
        this.informacoesAdicionais = informacoesAdicionais;
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

    @Override
    public String toString() {
        return "Certificado\n\n" +
                "dataEmissao= " + dataEmissao + '\n' +
                "assinatura= " + assinatura + '\n' +
                "informacoesAdicionais= " + informacoesAdicionais + '\n';
    }
}

