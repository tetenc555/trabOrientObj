import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    //testes envolvendo classe pessoa
    @Test
    void naoDeveDefinirNomeVazio() {
        try{
            Cliente p = new Cliente(null,123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))));
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Pessoa deve ter nome.",e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirIDNegativo() {
        try {
            Cliente p = new Cliente("João Srbek", -1, new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR"))));
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Pessoa deve ter ID maior que 0 para que seja válido.", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirCidadeVazia() {
        try{
            Cliente p = new Cliente("João Srbek",123,null);
            fail();
        }
        catch (NullPointerException e){
            assertEquals("Pessoa deve ter cidade.", e.getMessage());
        }
    }

    @Test
    void deveRetornarNomeCliente() {
        Cliente p = new Cliente("João Srbek",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))));
        assertEquals("João Srbek",p.getNome());
    }

    @Test
    void deveRetornarIDCliente() {
        Cliente p = new Cliente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))));
        assertEquals(1,p.getID());
    }

    @Test
    void deveRetornarNomeCidade() {
        Cliente p = new Cliente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))));
        assertEquals("Juiz de Fora",p.retornarNomeCidade());
    }

    @Test
    void deveRetornarSiglaCidade() {
        Cliente p = new Cliente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))));
        assertEquals("JF",p.retornarSiglaCidade());
    }

    @Test
    void deveRetornarNomeEstado() {
        Cliente p = new Cliente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))));
        assertEquals("Minas Gerais",p.retornarNomeEstado());
    }

    @Test
    void deveRetornarSiglaEstado() {
        Cliente p = new Cliente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))));
        assertEquals("MG",p.retornarSiglaEstado());
    }

    @Test
    void deveRetornarNomePais() {
        Cliente p = new Cliente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))));
        assertEquals("Brasil",p.retornarNomePais());
    }

    @Test
    void deveRetornarSiglaPais() {
        Cliente p = new Cliente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))));
        assertEquals("BR",p.retornarSiglaPais());
    }

    //testes envolvendo apenas cliente

    @Test
    void naoDeveDefinirQtdNegativaCompras(){
        try{
            Cliente p = new Cliente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))));
            p.setQtdCompras(-1);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Quantidade de Compras Inválida!", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirQtdComprasMaior52(){
        try{
            Cliente p = new Cliente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))));
            p.setQtdCompras(53);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Quantidade de Compras Inválida!", e.getMessage());
        }
    }

    @Test
    void deveDefinirQtdComprasZero(){
        Cliente p = new Cliente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))));
        p.setQtdCompras(0);
        assertEquals(0,p.getQtdCompras());
    }

    @Test
    void deveResetarQtdCompras(){
        Cliente p = new Cliente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))));
        p.setQtdCompras(52);
        assertEquals(1,p.getQtdCompras());
    }

    @Test
    void deveRetornarSeEhFidelidade(){
        Cliente p = new Cliente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))));
        assertFalse(p.isCartaoFidelidade());
    }

    @Test
    void naoDeveTornarFidelidadeCasoJaSeja(){
        try {
            Cliente p = new Cliente("João Srbek", 1, new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR"))));
            p.tornarFidelidade();
            p.tornarFidelidade();
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Já é fidelidade!",e.getMessage());
        }
    }

    @Test
    void deveTornarFidelidadeSeNaoFor(){
        Cliente p = new Cliente("João Srbek", 1, new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR"))));
        assertEquals("João Srbek se tornou fidelidade!",p.tornarFidelidade());
    }

    @Test
    void deveAdicionarCompra(){
        Cliente p = new Cliente("João Srbek", 1, new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR"))));
        p.adicionarCompra();
        assertEquals(1,p.getQtdCompras());
    }

}