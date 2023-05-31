package __tests__.bo;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;

import bo.Aluno;

import static org.junit.Assert.*;

public class AlunoTest {

    @Test
    public void testSetCpf(){
        Aluno aluno = new Aluno("12345678901", "Andrézin rei delas", "andrecardosoal99@gmail.com", LocalDate.of(1997, Month.AUGUST, 16), "82994227272");
        aluno.setCpf("12345678901");
        assertEquals("12345678901", aluno.getCpf());

        try {aluno.setCpf("123456780");
            fail("Deve lançar uma exception");
        } catch (IllegalArgumentException e) {
            assertEquals("CPF inválido", e.getMessage());
        }
    }
    @Test
    public void testSetEmail(){
        Aluno aluno = new Aluno("12345678901", "Andrézin rei delas", "andrecardosoal99@gmail.com", LocalDate.of(1997, Month.AUGUST, 16), "82994227272");
        assertEquals("andrecardosoal99@gmail.com", aluno.getEmail());

        try {
            aluno.setEmail("");
            fail("Deve lançar uma exception");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo email está vazio", e.getMessage());
        }
    }
}