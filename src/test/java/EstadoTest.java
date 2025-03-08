import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstadoTest {
    @Test
    void naoDeveDefinirNomeNulo() {
        try{
            Estado p = new Estado(null, "MG",new Pais("Brasil","BR"));
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("Estado deve possuir um nome.", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirSiglaNula() {
        try{
            Estado p = new Estado("Minas Gerais", null,new Pais("Brasil","BR"));
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("Estado deve possuir uma sigla.", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirPaisNulo() {
        try{
            Estado p = new Estado("Minas Gerais", "BR",null);
            fail();
        }
        catch(NullPointerException e){
            assertEquals("Estado deve possuir um pais.", e.getMessage());
        }
    }

    @Test
    void deveDefinirEstadoNome() {
        Estado p = new Estado ("Minas Gerais", "MG",new Pais("Brasil","BR"));
        assertEquals("Minas Gerais", p.getNome());
    }

    @Test
    void deveDefinirEstadoSigla() {
        Estado p = new Estado ("Minas Gerais", "MG",new Pais("Brasil","BR"));
        assertEquals("MG", p.getSigla());
    }

    @Test
    void deveRetornarNomePais() {
        Estado p = new Estado ("Minas Gerais", "MG",new Pais("Brasil","BR"));
        assertEquals("Brasil", p.retornarNomePais());
    }
    @Test
    void deveRetornarSiglaPais() {
        Estado p = new Estado ("Minas Gerais", "MG",new Pais("Brasil","BR"));
        assertEquals("BR", p.retornarSiglaPais());
    }
}