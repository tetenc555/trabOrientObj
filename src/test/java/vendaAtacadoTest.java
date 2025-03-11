import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class vendaAtacadoTest {
    //testes relacionados a Ocorrencia
    @Test
    void naoDeveDefinirDescricaoVazia() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Empresa e = new Empresa("Empresa 1", 456, a,  0);
            Parceiro p = new Parceiro("Empresa 2",1,a,1);
            vendaAtacado v = new vendaAtacado("", 20, 2, 2000f, p, e);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Ocorrência deve possuir descrição!", e.getMessage());
        }
    }

    @Test
    void deveRetonarDescricao() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,1);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, p, e);
        assertEquals("Venda de Lote de PCS", v.getDescricao());
    }

    @Test
    void deveRetornarTipoLucroCorreto() {  //vendaAtacado é sempre true, por definição
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,1);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, p, e);
        assertTrue(v.isLucro());
    }

    //testes relacionados a OcorrenciaProduto
    @Test
    void naoDeveDefinirEstoqueAtualNegativo() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Empresa e = new Empresa("Empresa 1", 456, a,  0);
            Parceiro p = new Parceiro("Empresa 2",1,a,1);
            vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", -1, 2, 2000f, p, e);
        } catch (IllegalArgumentException e) {
            assertEquals("Estoque inválido!", e.getMessage());
        }
    }

    @Test
    void deveDefinirEstoqueAtualZero() { //aqui também ja testamos o retorno de estoque
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,1);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 0, 2, 2000f, p, e);
        assertEquals(0, v.getEstoqueAtual()); //teste do get sera valido pois ele e usado no assertEquals
    }

    @Test
    void naoDeveDefinirQtdOcorrenciaZero() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Empresa e = new Empresa("Empresa 1", 456, a,  0);
            Parceiro p = new Parceiro("Empresa 2",1,a,1);
            vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 0, 2000f, p, e);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade de itens da ocorrência inválida!", e.getMessage());
        }
    }

    @Test
    void deveDefinirQtdOcorrenciaUm() { //aqui também ja testamos o retorno de qtdOcorrencia
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,1);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 1, 2000f, p, e);
        assertEquals(1, v.getQtdOcorrencia()); //teste do get sera valido pois ele e usado no assertEquals
    }

    @Test
    void naoDeveDefinirValorUnitarioZero() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Empresa e = new Empresa("Empresa 1", 456, a,  0);
            Parceiro p = new Parceiro("Empresa 2",1,a,1);
            vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 1, 0f, p, e);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor unitário inválido!", e.getMessage());
        }
    }

    @Test
    void deveDefinirValorUnitarioUm() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,1);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 1, 1f, p, e);
        assertEquals(1, v.getValorUnitario());
    }

    @Test
    void vendaNaoEhPossivelQtdMaiorEstoque() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,1);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 21, 1f, p, e);
        assertFalse(v.vendaEhPossivel());
    }

    @Test
    void vendaEhPossivelQtdIgualEstoque() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,1);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 20, 1f, p, e);
        assertTrue(v.vendaEhPossivel());
    }

    @Test
    void naoDeveCalcularValorFinalSeVendaNaoEhPossivel() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Empresa e = new Empresa("Empresa 1", 456, a,  0);
            Parceiro p = new Parceiro("Empresa 2",1,a,1);
            vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 21, 2000f, p, e);
            v.calcularValorFinal();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Não há estoque suficiente!", e.getMessage());
        }
    }


    @Test
    void deveCalcularValorFinalDescontoBase() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,0);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, p, e);
        assertEquals(3600f, v.calcularValorFinal());
    }

    //testes particulares a vendaAtacado

    @Test
    void deveRetornarValorFinalPositivo() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,0);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, p, e);
        assertEquals(3600f, v.retornarValorFinal());
    }

    @Test
    void naoDeveDefinirDestinatarioNulo() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Empresa e = new Empresa("Empresa 1", 456, a,  0);
            vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, null, e);
            fail();
        } catch (NullPointerException e) {
            assertEquals("Deve possuir um destinatário!", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirRemetenteNulo(){
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Parceiro p = new Parceiro("Empresa 2",1,a,0);
            vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, p, null);
            fail();
        }
        catch (NullPointerException e){
            assertEquals("Deve possuir um remetente!", e.getMessage());
        }
    }

    @Test
    void deveRetornarLocalEntrega(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,0);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, p, e);
        assertEquals("O endereço de destinatário é a Cidade Juiz de Fora no estado de Minas Gerais - BR",v.retornarLocalEntrega());
    }

    @Test
    void deveRetornarLocalRemetente(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,0);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, p, e);
        assertEquals("O endereço do remetente é a Cidade Juiz de Fora no estado de Minas Gerais - BR",v.retornarLocalRemetente());
    }

    @Test
    void deveCalcularDescontoBase(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,0);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, p, e);
        assertEquals(0.1f,v.calcularDesconto());
    }

    @Test
    void deveCalcularDescontoMenosCincoAnos(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,4);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, p, e);
        assertEquals(0.18f,v.calcularDesconto());
    }

    @Test
    void deveCalcularDescontoAcimaCincoAnos(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,6);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, p, e);
        assertEquals(0.2f,v.calcularDesconto());
    }

    @Test
    void deveCalcularValorComDesconto(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,4);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, p, e);
        assertEquals(3280f,v.calcularValorFinal());
    }

    @Test
    void deveRetornarValorPositivoComDesconto(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,4);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, p, e);
        assertEquals(3280f,v.retornarValorFinal());
    }

    //Consultas

    //Consulta 11
    @Test
    void deveRetornarNomeEstadoEntrega(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,4);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, p, e);
        assertEquals("Minas Gerais",v.retornarNomeEstadoDestinatario());
    }

    //Consulta 12
    @Test
    void deveRetornarNomePaisEntrega(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        Parceiro p = new Parceiro("Empresa 2",1,a,4);
        vendaAtacado v = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, p, e);
        assertEquals("Brasil",v.retornarNomePaisDestinatario());
    }
}