import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CidadeTest {
    @Test
    void naoDeveDefinirNomeNulo() {
        try{
            Cidade p = new Cidade (null, "JF",new Estado("Minas Gerais", "MG",new Pais("Brasil","BR")));
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("Cidade deve possuir um nome.", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirSiglaNula() {
        try{
            Cidade p = new Cidade ("Juiz de Fora", null,new Estado("Minas Gerais", "MG",new Pais("Brasil","BR")));
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("Cidade deve possuir uma sigla.", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirEstadoNulo() {
        try{
            Cidade p = new Cidade ("Juiz de Fora", "JF",null);
            fail();
        }
        catch(NullPointerException e){
            assertEquals("Cidade deve possuir um estado.", e.getMessage());
        }
    }

    @Test
    void deveDefinirCidadeNome() {
        Cidade p = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG",new Pais("Brasil","BR")));
        assertEquals("Juiz de Fora", p.getNome());
    }

    @Test
    void deveDefinirCidadeSigla() {
        Cidade p = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG",new Pais("Brasil","BR")));
        assertEquals("JF", p.getSigla());
    }

    @Test
    void deveRetornarNomeEstado() {
        Cidade p = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG",new Pais("Brasil","BR")));
        assertEquals("Minas Gerais", p.retornarNomeEstado());
    }
    @Test
    void deveRetornarSiglaEstado() {
        Cidade p = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG",new Pais("Brasil","BR")));
        assertEquals("MG", p.retornarSiglaEstado());
    }

    @Test
    void deveRetornarNomePais() {
        Cidade p = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG",new Pais("Brasil","BR")));
        assertEquals("Brasil", p.retornarNomePais());
    }
    @Test
    void deveRetornarSiglaPais() {
        Cidade p = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG",new Pais("Brasil","BR")));
        assertEquals("BR", p.retornarSiglaPais());
    }
}