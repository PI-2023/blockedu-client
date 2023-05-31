package bo;
import java.time.LocalDate;

public class Certificado {
    private LocalDate dataEmissao;
    private String assinatura;
    private String informacoesAdicionais;

    public Certificado(LocalDate dataEmissao, String assinatura, String informacoesAdicionais) {
        this.dataEmissao = dataEmissao;
        this.assinatura = assinatura;
        this.informacoesAdicionais = informacoesAdicionais;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        if (dataEmissao == null)
            throw new IllegalArgumentException("Data de emissão não estar vazia.");

        this.dataEmissao = dataEmissao;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        if (assinatura == null)
            throw new IllegalArgumentException("Assinatura não pode estar vazia.");

        this.assinatura = assinatura;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
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