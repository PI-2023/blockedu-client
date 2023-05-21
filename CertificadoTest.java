import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class CertificadoTest {

    @Test
    public void testSetDataEmissao_SetsDataEmissao() {
        LocalDate dataEmissao = LocalDate.of(2023, 5, 20);
        Certificado certificado = new Certificado(LocalDate.of(2022, 1, 1), "Assinatura", "Informações adicionais");

        certificado.setDataEmissao(dataEmissao);

        Assertions.assertEquals(dataEmissao, certificado.getDataEmissao());
    }

    @Test
    public void testSetAssinatura_SetsAssinatura() {
        String assinatura = "Nova assinatura";
        Certificado certificado = new Certificado(LocalDate.of(2022, 1, 1), "Assinatura", "Informações adicionais");

        certificado.setAssinatura(assinatura);

        Assertions.assertEquals(assinatura, certificado.getAssinatura());
    }

    @Test
    public void testSetInformacoesAdicionais_SetsInformacoesAdicionais() {
        String informacoesAdicionais = "Novas informações adicionais";
        Certificado certificado = new Certificado(LocalDate.of(2022, 1, 1), "Assinatura", "Informações adicionais");

        certificado.setInformacoesAdicionais(informacoesAdicionais);

        Assertions.assertEquals(informacoesAdicionais, certificado.getInformacoesAdicionais());

    }
}