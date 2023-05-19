import java.time.LocalDate;

public class CertificadoTest {
    public static void main(String[] args) {
        Certificado certificado = new Certificado(LocalDate.now(), "João da Silva", "Validade varios anos");

        System.out.println("Data de Emissão: " + certificado.getDataEmissao());
        System.out.println("Assinatura: " + certificado.getAssinatura());
        System.out.println("Informações Adicionais: " + certificado.getInformacoesAdicionais());

        certificado.setDataEmissao(LocalDate.of(2023, 5, 1));
        certificado.setAssinatura("Anitinha");
        certificado.setInformacoesAdicionais("Ta certificado (y)");

        System.out.println(certificado.toString());
    }
}