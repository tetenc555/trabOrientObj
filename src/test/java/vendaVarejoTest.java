import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class vendaVarejoTest {
    //testes relacionados a Ocorrencia
    @Test
    void naoDeveDefinirDescricaoVazia() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Cliente c = new Cliente("João Srbek", 1, a);
            Empresa e = new Empresa("Empresa 1", 456, a,  0);
            vendaVarejo v = new vendaVarejo("", 20, 2, 2000f, c, e);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Ocorrência deve possuir descrição!", e.getMessage());
        }
    }

    @Test
    void deveRetonarDescricao() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 2, 2000f, c, e);
        assertEquals("Venda de iPhone 16e", v.getDescricao());
    }

    @Test
    void deveRetornarTipoLucroCorreto() {  //vendaVarejo é sempre true, por definição
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 2, 2000f, c, e);
        assertTrue(v.isLucro());
    }

    //testes relacionados a OcorrenciaProduto
    @Test
    void naoDeveDefinirEstoqueAtualNegativo() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Cliente c = new Cliente("João Srbek", 1, a);
            Empresa e = new Empresa("Empresa 1", 456, a,  0);
            vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", -1, 2, 2000f, c, e);
        } catch (IllegalArgumentException e) {
            assertEquals("Estoque inválido!", e.getMessage());
        }
    }

    @Test
    void deveDefinirEstoqueAtualZero() { //aqui também ja testamos o retorno de estoque
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 0, 2, 2000f, c, e);
        assertEquals(0, v.getEstoqueAtual()); //teste do get sera valido pois ele e usado no assertEquals
    }

    @Test
    void naoDeveDefinirQtdOcorrenciaZero() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Cliente c = new Cliente("João Srbek", 1, a);
            Empresa e = new Empresa("Empresa 1", 456, a,  0);
            vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 0, 2000f, c, e);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade de itens da ocorrência inválida!", e.getMessage());
        }
    }

    @Test
    void deveDefinirQtdOcorrenciaUm() { //aqui também ja testamos o retorno de qtdOcorrencia
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 1, 2000f, c, e);
        assertEquals(1, v.getQtdOcorrencia()); //teste do get sera valido pois ele e usado no assertEquals
    }

    @Test
    void naoDeveDefinirValorUnitarioZero() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Cliente c = new Cliente("João Srbek", 1, a);
            Empresa e = new Empresa("Empresa 1", 456, a,  0);
            vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 1, 0f, c, e);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor unitário inválido!", e.getMessage());
        }
    }

    @Test
    void deveDefinirValorUnitarioUm() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 1, 1f, c, e);
        assertEquals(1, v.getValorUnitario());
    }

    @Test
    void vendaNaoEhPossivelQtdMaiorEstoque() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 21, 1f, c, e);
        assertFalse(v.vendaEhPossivel());
    }

    @Test
    void vendaEhPossivelQtdIgualEstoque() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 20, 1f, c, e);
        assertTrue(v.vendaEhPossivel());
    }

    @Test
    void naoDeveCalcularValorFinalSeVendaNaoEhPossivel() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Cliente c = new Cliente("João Srbek", 1, a);
            Empresa e = new Empresa("Empresa 1", 456, a,  0);
            vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 21, 2000f, c, e);
            v.calcularValorFinal();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Não há estoque suficiente!", e.getMessage());
        }
    }


    @Test
    void deveCalcularValorFinalSemDesconto() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 2, 2000f, c, e);
        assertEquals(4000f, v.calcularValorFinal());
    }

    //testes vendaVarejo

    @Test
    void deveRetornarValorFinalPositvo() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 2, 2000f, c, e);
        assertEquals(4000f, v.retornarValorFinal());
    }

    @Test
    void naoDeveDefinirDestinatarioNulo() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Empresa e = new Empresa("Empresa 1", 456, a,  0);
            vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 2, 2000f, null, e);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Deve possuir um destinatário!", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirRemetenteNulo(){
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Cliente c = new Cliente("João Srbek", 1,a);
            vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 2, 2000f, c,null);
            fail();
        }
        catch (NullPointerException e){
            assertEquals("Deve possuir um remetente!", e.getMessage());
        }
    }

    @Test
    void deveRetornarLocalEntrega(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 2, 2000f, c, e);
        assertEquals("O endereço de destinatário é a Cidade Juiz de Fora no estado de Minas Gerais - BR",v.retornarLocalEntrega());
    }

    @Test
    void deveRetornarLocalRemetente(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 2, 2000f, c, e);
        assertEquals("O endereço do remetente é a Cidade Juiz de Fora no estado de Minas Gerais - BR",v.retornarLocalRemetente());
    }

    @Test
    void deveCalcularDescontoZero(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 2, 2000f, c, e);
        assertEquals(0f,v.calcularDesconto());
    }

    @Test
    void deveCalcularDescontoApenasCartaoFidelidade(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 2, 2000f, c, e);
        c.tornarFidelidade();
        assertEquals(0.1f,v.calcularDesconto());
    }

    @Test
    void deveCalcularDescontoApenasQtdCompras(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 2, 2000f, c, e);
        c.setQtdCompras(13);
        assertEquals(0.02f,v.calcularDesconto());
    }

    @Test
    void deveCalcularDescontoComDoisItens(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 2, 2000f, c, e);
        c.tornarFidelidade();
        c.setQtdCompras(23);
        assertEquals(0.14f,v.calcularDesconto());
    }

    @Test
    void deveCalcularValorComDesconto(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 2, 2000f, c, e);
        c.tornarFidelidade();
        c.setQtdCompras(23);
        assertEquals(3440f,v.calcularValorFinal());
    }

    @Test
    void deveRetornarValorPositivoComDesconto(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Cliente c = new Cliente("João Srbek", 1, a);
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        vendaVarejo v = new vendaVarejo("Venda de iPhone 16e", 20, 2, 2000f, c, e);
        c.tornarFidelidade();
        c.setQtdCompras(23);
        assertEquals(3440f,v.retornarValorFinal());
    }
}
