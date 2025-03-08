import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaisTest {
    @Test
    void naoDeveDefinirNomeNulo() {
        try{
            Pais p = new Pais(null, "BR");
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("País deve possuir um nome.", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirSiglaNula() {
        try{
            Pais p = new Pais("Brasil", null);
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("País deve possuir uma sigla.", e.getMessage());
        }
    }

    @Test
    void deveDefinirPaisNome() {
        Pais p = new Pais ("Brasil", "BR");
        assertEquals("Brasil", p.getNome());
    }

    @Test
    void deveDefinirPaisSigla() {
        Pais p = new Pais ("Brasil", "BR");
        assertEquals("BR", p.getSigla());
    }
}