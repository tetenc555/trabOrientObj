import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DependenteTest {
    //testes envolvendo classe pessoa
    @Test
    void naoDeveDefinirNomeVazio() {
        try{
            Dependente p = new Dependente(null,123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Pessoa deve ter nome.",e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirIDNegativo() {
        try {
            Dependente p = new Dependente("João Srbek", -1, new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR"))), 1);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Pessoa deve ter ID maior que 0 para que seja válido.", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirCidadeVazia() {
        try{
            Dependente p = new Dependente("João Srbek",123,null,1);
            fail();
        }
        catch (NullPointerException e){
            assertEquals("Pessoa deve ter cidade.", e.getMessage());
        }
    }

    @Test
    void deveRetornarNomeDependente() {
        Dependente p = new Dependente("João Srbek",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals("João Srbek",p.getNome());
    }

    @Test
    void deveRetornarIDDependente() {
        Dependente p = new Dependente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals(1,p.getID());
    }

    @Test
    void deveRetornarNomeCidade() {
        Dependente p = new Dependente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals("Juiz de Fora",p.retornarNomeCidade());
    }

    @Test
    void deveRetornarSiglaCidade() {
        Dependente p = new Dependente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals("JF",p.retornarSiglaCidade());
    }

    @Test
    void deveRetornarNomeEstado() {
        Dependente p = new Dependente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals("Minas Gerais",p.retornarNomeEstado());
    }

    @Test
    void deveRetornarSiglaEstado() {
        Dependente p = new Dependente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals("MG",p.retornarSiglaEstado());
    }

    @Test
    void deveRetornarNomePais() {
        Dependente p = new Dependente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals("Brasil",p.retornarNomePais());
    }

    @Test
    void deveRetornarSiglaPais() {
        Dependente p = new Dependente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1);
        assertEquals("BR",p.retornarSiglaPais());
    }

    //testes envolvendo dependente

    @Test
    void naoDeveDefinirIdadeNegativa(){
        try{
            Dependente p = new Dependente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),-1);
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("Idade negativa é inválida!",e.getMessage());
        }
    }

    @Test
    void deveRetornarIdade(){
        Dependente p = new Dependente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),0);
        assertEquals(0,p.getIdade());
    }
}