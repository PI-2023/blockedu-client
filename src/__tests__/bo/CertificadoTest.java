package __tests__.bo;

import org.junit.Test;

import bo.Certificado;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.Month;

public class CertificadoTest {

    @Test
    public void testSetDataEmissao() {
        Certificado certificado = new Certificado(LocalDate.of(2007, Month.MAY, 19), "Andrézin rei delas", "Curso introdutorio em java recomendo muito!");
        certificado.setDataEmissao(LocalDate.of(2007, Month.MAY, 19));
        assertEquals(LocalDate.of(2007, Month.MAY, 19), certificado.getDataEmissao());

        try {certificado.setDataEmissao(null);
            fail("Deve lançar uma exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Data de emissão não pode estar vazia.", e.getMessage());
        }
    }

    @Test
    public void testSetAssinatura(){
        Certificado certificado = new Certificado(LocalDate.of(2007, Month.MAY, 19), "Andrézin rei delas", "Curso introdutorio em java recomendo muito!");
        certificado.setAssinatura("Andrézin rei delas");
        assertEquals("Andrézin rei delas", certificado.getAssinatura());

        try {
            certificado.setAssinatura("");
            fail("Deve lançar uma exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Assinatura não pode estar vazia.", e.getMessage());
        }
    }


}