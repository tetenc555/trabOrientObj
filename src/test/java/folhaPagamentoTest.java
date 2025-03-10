import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class folhaPagamentoTest {
    //testes relacionados a Ocorrencia
    @Test
    void naoDeveDefinirDescricaoVazia() {
        try {
            folhaPagamento v = new folhaPagamento("",1.5f);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Ocorrência deve possuir descrição!", e.getMessage());
        }
    }

    @Test
    void deveRetonarDescricao() {
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio",1.5f);
        assertEquals("Folha de Pagamento do Mês de Maio", v.getDescricao());
    }

    @Test
    void deveRetornarTipoLucroCorreto() {  //folhaPagamento é sempre false, por definição
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio",1.5f);
        assertFalse(v.isLucro());
    }
}