import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//Parceiro p = new Parceiro("Empresa 1",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);

class ParceiroTest {
    //testes envolvendo classe pessoa
    @Test
    void naoDeveDefinirNomeVazio() {
        try{
            Parceiro p = new Parceiro(null,123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Pessoa deve ter nome.",e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirIDNegativo() {
        try {
            Parceiro p = new Parceiro("Empresa 1", -1, new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR"))), 1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Pessoa deve ter ID maior que 0 para que seja válido.", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirCidadeVazia() {
        try{
            Parceiro p = new Parceiro("Empresa 1",123,null,1);
            fail();
        }
        catch (NullPointerException e){
            assertEquals("Pessoa deve ter cidade.", e.getMessage());
        }
    }

    @Test
    void deveRetornarNomeParceiro() {
        Parceiro p = new Parceiro("Empresa 1",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals("Empresa 1",p.getNome());
    }

    @Test
    void deveRetornarIDParceiro() {
        Parceiro p = new Parceiro("Empresa 1",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals(1,p.getID());
    }

    @Test
    void deveRetornarNomeCidade() {
        Parceiro p = new Parceiro("Empresa 1",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals("Juiz de Fora",p.retornarNomeCidade());
    }

    @Test
    void deveRetornarSiglaCidade() {
        Parceiro p = new Parceiro("Empresa 1",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals("JF",p.retornarSiglaCidade());
    }

    @Test
    void deveRetornarNomeEstado() {
        Parceiro p = new Parceiro("Empresa 1",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals("Minas Gerais",p.retornarNomeEstado());
    }

    @Test
    void deveRetornarSiglaEstado() {
        Parceiro p = new Parceiro("Empresa 1",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals("MG",p.retornarSiglaEstado());
    }

    @Test
    void deveRetornarNomePais() {
        Parceiro p = new Parceiro("Empresa 1",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals("Brasil",p.retornarNomePais());
    }

    @Test
    void deveRetornarSiglaPais() {
        Parceiro p = new Parceiro("Empresa 1",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals("BR",p.retornarSiglaPais());
    }

    //testes particulares ao parceiro
    @Test
    void naoDeveDefinirAnosParceriaMenorZero(){
        try{
            Parceiro p = new Parceiro("Empresa 1",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),-1);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Anos de parceria inválido!",e.getMessage());
        }
    }

    @Test
    void deveRetornarAnosParceria() {
        Parceiro p = new Parceiro("Empresa 1",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),0);
        assertEquals(0,p.getAnosParceria());
    }
}