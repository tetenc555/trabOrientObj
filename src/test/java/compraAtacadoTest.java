import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class compraAtacadoTest {
    //testes relacionados a Ocorrencia
    @Test
    void naoDeveDefinirDescricaoVazia() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Empresa e = new Empresa("Empresa 1", 456, a, 0, 0);
            Parceiro p = new Parceiro("Empresa 2",1,a,1);
            compraAtacado v = new compraAtacado("Compra de material de Limpeza", 20, 2, 2000f, e, p);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Ocorrência deve possuir descrição!", e.getMessage());
        }
    }

    @Test
    void deveRetonarDescricao() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a, 0, 0);
        Parceiro p = new Parceiro("Empresa 2",1,a,1);
        compraAtacado v = new compraAtacado("Compra de material de Limpeza", 20, 2, 2000f, e, p);
        assertEquals("Compra de material de Limpeza", v.getDescricao());
    }

    @Test
    void deveRetornarTipoLucroCorreto() {  //compraAtacado é sempre false, por definição
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a, 0, 0);
        Parceiro p = new Parceiro("Empresa 2",1,a,1);
        compraAtacado v = new compraAtacado("Compra de material de Limpeza", 20, 2, 2000f, e, p);
        assertFalse(v.isLucro());
    }

    //testes relacionados a OcorrenciaProduto
    @Test
    void naoDeveDefinirEstoqueAtualNegativo() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Empresa e = new Empresa("Empresa 1", 456, a, 0, 0);
            Parceiro p = new Parceiro("Empresa 2",1,a,1);
            compraAtacado v = new compraAtacado("Compra de material de Limpeza", -1, 2, 2000f, e, p);
        } catch (IllegalArgumentException e) {
            assertEquals("Estoque inválido!", e.getMessage());
        }
    }

    @Test
    void deveDefinirEstoqueAtualZero() { //aqui também ja testamos o retorno de estoque
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a, 0, 0);
        Parceiro p = new Parceiro("Empresa 2",1,a,1);
        compraAtacado v = new compraAtacado("Compra de material de Limpeza", 0, 2, 2000f, e, p);
        assertEquals(0, v.getEstoqueAtual()); //teste do get sera valido pois ele e usado no assertEquals
    }

    @Test
    void naoDeveDefinirQtdOcorrenciaZero() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Empresa e = new Empresa("Empresa 1", 456, a, 0, 0);
            Parceiro p = new Parceiro("Empresa 2",1,a,1);
            compraAtacado v = new compraAtacado("Compra de material de Limpeza", 20, 0, 2000f, e, p);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Quantidade de itens da ocorrência inválida!", e.getMessage());
        }
    }

    @Test
    void deveDefinirQtdOcorrenciaUm() { //aqui também ja testamos o retorno de qtdOcorrencia
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a, 0, 0);
        Parceiro p = new Parceiro("Empresa 2",1,a,1);
        compraAtacado v = new compraAtacado("Compra de material de Limpeza", 20, 1, 2000f, e, p);
        assertEquals(1, v.getQtdOcorrencia()); //teste do get sera valido pois ele e usado no assertEquals
    }

    @Test
    void naoDeveDefinirValorUnitarioZero() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Empresa e = new Empresa("Empresa 1", 456, a, 0, 0);
            Parceiro p = new Parceiro("Empresa 2",1,a,1);
            compraAtacado v = new compraAtacado("Compra de material de Limpeza", 20, 1, 0f, e, p);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Valor unitário inválido!", e.getMessage());
        }
    }

    @Test
    void deveDefinirValorUnitarioUm() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a, 0, 0);
        Parceiro p = new Parceiro("Empresa 2",1,a,1);
        compraAtacado v = new compraAtacado("Compra de material de Limpeza", 20, 1, 1f, e, p);
        assertEquals(1, v.getValorUnitario());
    }

    @Test
    void vendaNaoEhPossivelQtdMaiorEstoque() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a, 0, 0);
        Parceiro p = new Parceiro("Empresa 2",1,a,1);
        compraAtacado v = new compraAtacado("Compra de material de Limpeza", 20, 21, 1f, e, p);
        assertFalse(v.vendaEhPossivel());
    }

    @Test
    void vendaEhPossivelQtdIgualEstoque() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a, 0, 0);
        Parceiro p = new Parceiro("Empresa 2",1,a,1);
        compraAtacado v = new compraAtacado("Compra de material de Limpeza", 20, 20, 1f, e, p);
        assertTrue(v.vendaEhPossivel());
    }

    @Test
    void naoDeveCalcularValorFinalSeVendaNaoEhPossivel() {
        try {
            Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
            Empresa e = new Empresa("Empresa 1", 456, a, 0, 0);
            Parceiro p = new Parceiro("Empresa 2",1,a,1);
            compraAtacado v = new compraAtacado("Compra de material de Limpeza", 20, 21, 2000f, e, p);
            v.calcularValorFinal();
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Não há estoque suficiente!", e.getMessage());
        }
    }


    @Test
    void deveCalcularValorFinalDescontoBase() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a, 0, 0);
        Parceiro p = new Parceiro("Empresa 2",1,a,0);
        compraAtacado v = new compraAtacado("Compra de material de Limpeza", 20, 2, 2000f, e, p);
        assertEquals(3600f, v.calcularValorFinal());
    }


}