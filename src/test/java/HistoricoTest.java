import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HistoricoTest {

    @Test
    void deveAdicionarOcorrencia() {
        Historico h = new Historico();
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 1.5f);
        Cidade c = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR")));
        Empresa e = new Empresa("Empresa 1", 456, c, 0, 0);
        Parceiro j = new Parceiro("Empresa 2",1,c,0);
        vendaAtacado g = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, j, e);
        h.addOcorrencia(v);
        h.addOcorrencia(g);
        ArrayList<Ocorrencia> testar = new ArrayList<Ocorrencia>();
        testar.add(v);
        testar.add(g);
        assertEquals(testar,h.getOcorrencias());
    }

    @Test
    void deveCalcularLucroFinal(){
        Historico h = new Historico();
        Cidade c = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR")));
        Funcionario p = new Funcionario("Fernando Silva",123,c,1412.0f,100.0f);
        Dependente p1 = new Dependente("João Srbek",1,c,17);
        Dependente p2 = new Dependente("Caua Moreno",2,c,18);
        Dependente p3 = new Dependente("Pedro Moreno Srbek",3,c,19);
        p.addDependentes(p1);
        p.addDependentes(p2);
        p.addDependentes(p3);
        Funcionario d = new Funcionario("Carlos",456,c,1412.0f,0.0f);
        Dependente d1 = new Dependente("Carlos Junior",4,c,17);
        d.addDependentes(d1);
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 1.5f);
        v.adicionarFuncionario(p);
        v.adicionarFuncionario(d);
        Empresa e = new Empresa("Empresa 1", 456, c, 0, 0);
        Parceiro j = new Parceiro("Empresa 2",1,c,0);
        vendaAtacado g = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, j, e);
        h.addOcorrencia(v);
        h.addOcorrencia(g);
        assertEquals(423f,h.calcularLucroFinal());
    }

    @Test
    void deveImprimirDescricoes(){
        Historico h = new Historico();
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 1.5f);
        Cidade c = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR")));
        Empresa e = new Empresa("Empresa 1", 456, c, 0, 0);
        Parceiro j = new Parceiro("Empresa 2",1,c,0);
        vendaAtacado g = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, j, e);
        h.addOcorrencia(v);
        h.addOcorrencia(g);
        assertEquals("Folha de Pagamento do Mês de Maio\nVenda de Lote de PCS\n",h.imprimirDescricoes());
    }

    @Test
    void deveImprimirDetalhado(){
        Historico h = new Historico();
        folhaPagamento k = new folhaPagamento("Folha de Pagamento Vazia", 0f);
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 1.5f);
        Cidade c = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR")));
        Funcionario p = new Funcionario("Fernando Silva",123,c,1412.0f,100.0f);
        Empresa e = new Empresa("Empresa 1", 456, c, 0, 0);
        Parceiro j = new Parceiro("Empresa 2",1,c,0);
        vendaAtacado g = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, j, e);
        h.addOcorrencia(v);
        h.addOcorrencia(g);
        h.addOcorrencia(k);
        v.adicionarFuncionario(p);
        assertEquals("Prejuízo de R$1313.5 - Folha de Pagamento do Mês de Maio\nLucro de R$3600.0 - Venda de Lote de PCS\nNão houve mudança no faturamento - Folha de Pagamento Vazia\n",h.imprimirDetalhado());
    }
}