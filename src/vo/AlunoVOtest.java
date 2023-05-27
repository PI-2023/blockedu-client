package vo;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;
import static org.junit.Assert.*;

public class AlunoVOtest {

    @Test
    public void testSetNome(){
        AlunoVO aluno = new AlunoVO(1, "12345678901", "Andrézin rei delas", "andrecardosoal99@gmail.com",LocalDate.of(1997, Month.AUGUST, 16), "82994227272");
        assertEquals("Andrézin rei delas", aluno.getNome());

        try {
            aluno.setNome("An");
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo nome deve ter no mínimo 3 caracteres", e.getMessage());
        }

        try {
            aluno.setNome("André maximus decimus meridius decimus maximus decimus meridius decimus maximos maximus maximus meridius");
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo nome deve ter no máximo 50 caracteres", e.getMessage());
        }
    }
    @Test
    public void testSetEmail(){
        AlunoVO aluno = new AlunoVO(1, "12345678901", "Andrézin rei delas", "andrecardosoal99@gmail.com",LocalDate.of(1997, Month.AUGUST, 16), "82994227272");
        assertEquals("andrecardosoal99@gmail.com", aluno.getEmail());

        try {
            aluno.setEmail("a@gmail.com");
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo email deve ter no mínimo 11 caracteres", e.getMessage());
        }

        try {
            aluno.setEmail("andreoluizluizoluizcardosooluizdaoluizsilvaoluiz@aluno.ifal.edu.gmail.com");
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo email deve ter no máximo 64 caracteres", e.getMessage());
        }
    }

    @Test
    public void testSetDataNascimento(){
        AlunoVO aluno = new AlunoVO(1, "12345678901", "Andrézin rei delas", "andrecardosoal99@gmail.com", LocalDate.of(1997, Month.AUGUST, 16), "82994227272");
        assertEquals(LocalDate.of(1997, Month.AUGUST, 16), aluno.getDataNascimento());

        try {
            aluno.setDataNascimento(LocalDate.of(2024, Month.AUGUST, 16));
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo data de nascimento deve ser anterior a data atual", e.getMessage());
        }

        try{
            aluno.setDataNascimento(LocalDate.of(1899, Month.AUGUST, 16));
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo data de nascimento deve ser posterior a 01/01/1900", e.getMessage());
        }
    }

    @Test
    public void testSetTelefoneCelular() {
        AlunoVO aluno = new AlunoVO(1, "12345678901", "Andrézin rei delas", "andrecardosoal99@gmail.com", LocalDate.of(1997, Month.AUGUST, 16), "82994227272");
        assertEquals("82994227272", aluno.getTelefoneCelular());

        try {
            aluno.setTelefoneCelular("8299422727");
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo telefone celular deve ter no mínimo 11 caracteres", e.getMessage());
        }

        try {
            aluno.setTelefoneCelular("82894227275");
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo telefone celular deve iniciar com 9 após o DDD caracteres", e.getMessage());
        }
    }


}
