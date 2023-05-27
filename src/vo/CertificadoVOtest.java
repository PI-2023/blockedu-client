package vo;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.Month;
public class CertificadoVOtest {

    @Test

    public void testSetDataEmissao() {
        CertificadoVO certificado = new CertificadoVO(LocalDate.of(2007, Month.MAY, 19), "Andrézin rei delas", "Curso introdutorio em java recomendo muito!");
        certificado.setDataEmissao(LocalDate.of(2007, Month.MAY, 19));
        assertEquals(LocalDate.of(2007, Month.MAY, 19), certificado.getDataEmissao());

        try {
            certificado.setDataEmissao(LocalDate.of(2024, Month.MAY, 19));
            fail("Deveria lançar exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("A data de emissão não pode ser posterior à data atual", e.getMessage());
        }

        try {
            certificado.setDataEmissao(LocalDate.of(1899, Month.MAY, 19));
            fail("Deveria lançar exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("A data de emissão não pode ser anterior à 01/01/1900", e.getMessage());
        }
    }

    @Test
    public void testSetInformacoesAdicionais() {
        CertificadoVO certificado = new CertificadoVO(LocalDate.of(2007, Month.MAY, 19), "Andrézin rei delas", "Curso introdutorio em java recomendo muito!");
        certificado.setInformacoesAdicionais("Curso introdutorio em java recomendo muito!");
        assertEquals("Curso introdutorio em java recomendo muito!", certificado.getInformacoesAdicionais());

        try {
            certificado.setInformacoesAdicionais("A text with 300 caracteres Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam tortor velit, maximus eu ultricies a, tristique ut mauris. Proin vitae sem magna. Curabitur fermentum rhoncus orci. Curabitur ut lorem tortor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nulla nec felis iaculis, imperdiet augue in, aliquet dolor. Donec nisi ligula, tincidunt nec efficitur id, efficitur ut magna. Sed sed ultrices est, nec dapibus nulla. Aenean eget dui metus. Nu Duis bibendum mattis sem et porta. Aenean tristique dictum est quis viverra. Maecenas placerat, massa vitae finibus euismod, lacus mi interdum est, ut gravida nisi augue at enim. Vestibulum commodo ultricies purus, ac congue odio maximus eu. Proin feugiat tristique orci cursus ultricies. Aliquam dictum ante justo, ut rutrum ex varius sed. Duis viverra, nulla ut tempus elementum, massa ligula facilisis ligula, ullamcorper interdum eros urna vel augue. Ut rhoncus, mi lobortis cursus venenatis, orci nulla blandit tortor, sed porta magna mauris id sapien. Fusce ac euismod lacus, et suscipit purus. Fusce hendrerit, urna a commodo finibus, dui urna tempor enim, id eleifend enim justo vel nisi. Nullam rhoncus dictum consequat. Donec dapibus, lacus vel consectetur pulvinar, enim arcu vestibulum lacus, eu fermentum ligula libero et dolor. Ut tempor condimentum dui tincidunt eleifend. Etiam ultricies commodo diam quis suscipit. Aenean diam est, dictum eu odio ut, iaculis porta lacus. Cras vulputate, risus et vulputate scelerisque, enim ante congue dui, id molestie felis diam in eros. Nulla fringilla mattis lectus. Nullam luctus neque turpis, non ultricies ipsum rutrum in. Vivamus posuere leo sed luctus volutpat. Duis vehicula, nisl a ornare dictum, massa turpis gravida ligula, quis aliquam sem tortor et dolor. Aliquam faucibus sed dui nec efficitur. Curabitur nisl dolor, maximus a ante ac, dignissim condimentum dolor. Phasellus accumsan accumsan lacus, sit amet dapibus dui tincidunt vitae. Mauris. Lorem com mais de 300 words para testar");
        } catch (IllegalArgumentException e) {
            assertEquals("As informações adicionais não devem ter mais de 300 caracteres", e.getMessage());
        }
    }
}
