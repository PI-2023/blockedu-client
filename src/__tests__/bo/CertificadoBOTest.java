package __tests__.bo;

import org.junit.Test;

import vo.CertificadoVO;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.Month;

public class CertificadoBOTest {

    @Test
    public void testSetDataEmissao() {
        CertificadoVO certificado = new CertificadoVO(LocalDate.of(2007, Month.MAY, 19), "Andrézin rei delas", "Curso introdutorio em java recomendo muito!");
        certificado.setDataEmissao(LocalDate.of(2007, Month.MAY, 19));
        assertEquals(LocalDate.of(2007, Month.MAY, 19), certificado.getDataEmissao());

        try {certificado.setDataEmissao(null);
            fail("Deve lançar uma exception");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testSetAssinatura(){
        CertificadoVO certificado = new CertificadoVO(LocalDate.of(2007, Month.MAY, 19), "Andrézin rei delas", "Curso introdutorio em java recomendo muito!");
        certificado.setAssinatura("Andrézin rei delas");
        assertEquals("Andrézin rei delas", certificado.getAssinatura());

        try {
            certificado.setAssinatura("");
            fail("Deve lançar uma exception");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }


}