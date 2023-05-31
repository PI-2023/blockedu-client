package __tests__.vo;
import org.junit.Test;

import vo.CursoVO;

import static org.junit.Assert.*;
public class CursoVOtest {

    @Test
    public void testSetNome(){
        CursoVO curso = new CursoVO("nome", "descricao", 10);
        curso.setNome("nome");
        assertEquals("nome", curso.getNome());

        try {
            curso.setNome("Al");
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo nome não pode haver menos de 3 caracteres.", e.getMessage());
        }

        try {
            curso.setNome("Curso aplicado de java e aplicação com aplicagem a aplicamentos teste de 50 caracteres para nome do curso alem do mais é um curso muito bom");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo nome não pode haver mais de 50 caracteres.", e.getMessage());
        }
    }

    @Test
    public void testSetDescricao(){
        CursoVO curso = new CursoVO("nome", "descricao", 10);
        curso.setDescricao("descricao");
        assertEquals("descricao", curso.getDescricao());

        try {
            curso.setDescricao("Andrezin");
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo descrição não pode haver menos de 10 caracteres.", e.getMessage());
        }

        try {
            curso.setDescricao("A text with 300 caracteres Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam tortor velit, maximus eu ultricies a, tristique ut mauris. Proin vitae sem magna. Curabitur fermentum rhoncus orci. Curabitur ut lorem tortor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Nulla nec felis iaculis, imperdiet augue in, aliquet dolor. Donec nisi ligula, tincidunt nec efficitur id, efficitur ut magna. Sed sed ultrices est, nec dapibus nulla. Aenean eget dui metus. Nu Duis bibendum mattis sem et porta. Aenean tristique dictum est quis viverra. Maecenas placerat, massa vitae finibus euismod, lacus mi interdum est, ut gravida nisi augue at enim. Vestibulum commodo ultricies purus, ac congue odio maximus eu. Proin feugiat tristique orci cursus ultricies. Aliquam dictum ante justo, ut rutrum ex varius sed. Duis viverra, nulla ut tempus elementum, massa ligula facilisis ligula, ullamcorper interdum eros urna vel augue. Ut rhoncus, mi lobortis cursus venenatis, orci nulla blandit tortor, sed porta magna mauris id sapien. Fusce ac euismod lacus, et suscipit purus. Fusce hendrerit, urna a commodo finibus, dui urna tempor enim, id eleifend enim justo vel nisi. Nullam rhoncus dictum consequat. Donec dapibus, lacus vel consectetur pulvinar, enim arcu vestibulum lacus, eu fermentum ligula libero et dolor. Ut tempor condimentum dui tincidunt eleifend. Etiam ultricies commodo diam quis suscipit. Aenean diam est, dictum eu odio ut, iaculis porta lacus. Cras vulputate, risus et vulputate scelerisque, enim ante congue dui, id molestie felis diam in eros. Nulla fringilla mattis lectus. Nullam luctus neque turpis, non ultricies ipsum rutrum in. Vivamus posuere leo sed luctus volutpat. Duis vehicula, nisl a ornare dictum, massa turpis gravida ligula, quis aliquam sem tortor et dolor. Aliquam faucibus sed dui nec efficitur. Curabitur nisl dolor, maximus a ante ac, dignissim condimentum dolor. Phasellus accumsan accumsan lacus, sit amet dapibus dui tincidunt vitae. Mauris. Lorem com mais de 300 words para testar");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo descrição não pode haver mais de 300 caracteres.", e.getMessage());
        }
    }

    @Test
    public void testSetCargaHoraria(){
        CursoVO curso = new CursoVO("nome", "descricao", 10);
        curso.setCargaHoraria(10);
        assertEquals(10, curso.getCargaHoraria());

        try {
            curso.setCargaHoraria(3);
            fail("Deveria ter lançado uma exceção");
        } catch (IllegalArgumentException e) {
            assertEquals("O campo carga horária não pode ser menor que 4 horas..", e.getMessage());
        }

    }

}