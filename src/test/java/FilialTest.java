import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilialTest {
    @Test
    void naoDeveDefinirHistoricoNulo(){
        try{
            Filial f = new Filial(null);
            fail();
        }
        catch(NullPointerException e){
            assertEquals("Filial deve possuir histórico!", e.getMessage());
        }
    }

    @Test
    void deveRetornarHistorico(){
        Historico h = new Historico();
        Filial f = new Filial(h);
        assertEquals(h,f.getHistorico());
    }

    @Test
    void DeveRetornarCoordenadorNulo(){
        Filial f = new Filial(new Historico());
        assertEquals(null,f.getCoordenadorLocal());
    }

    @Test
    void deveRetornarCoordenadorLocalDefinido() {
        Funcionario p = new Funcionario("Fernando Silva", 123, new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR"))), 1412.0f, 0.0f);
        Filial f = new Filial(new Historico());
        f.setCoordenadorLocal(p);
        assertEquals(p, f.getCoordenadorLocal());
    }

    @Test
    void deveImprimirHistorico(){
        Historico h = new Historico();
        folhaPagamento k = new folhaPagamento("Folha de Pagamento Vazia", 0f);
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 1.5f);
        Cidade c = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR")));
        Funcionario p = new Funcionario("Fernando Silva",123,c,1412.0f,100.0f);
        Empresa e = new Empresa("Empresa 1", 456, c,  0);
        Parceiro j = new Parceiro("Empresa 2",1,c,0);
        vendaAtacado g = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, j, e);
        h.addOcorrencia(v);
        h.addOcorrencia(g);
        h.addOcorrencia(k);
        v.adicionarFuncionario(p);
        Filial f = new Filial(h);
        assertEquals("Prejuízo de R$1313.5 - Folha de Pagamento do Mês de Maio\nLucro de R$3600.0 - Venda de Lote de PCS\nNão houve mudança no faturamento - Folha de Pagamento Vazia\n",f.imprimirHistorico());
    }


    @Test
    void deveRetornarErroQtdDependentesCoordenadorNulo(){
        try{
            Filial f = new Filial(new Historico());
            f.qtdDependentesCoordenadorLocal();
            fail();
        }
        catch(NullPointerException e){
            assertEquals("Não há coordenador local na Filial!",e.getMessage());
        }
    }

    @Test
    void deveRetornarErroQtdDepsAbonadosCoordenadorNulo(){
        try{
            Filial f = new Filial(new Historico());
            f.qtdDepsAbonoCoordenadorLocal();
            fail();
        }
        catch(NullPointerException e){
            assertEquals("Não há coordenador local na Filial!",e.getMessage());
        }
    }

    //Consultas

    //Consulta 8
    @Test
    void deveRetornarQtdDependentesCoordenador(){
        Cidade c = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR")));
        Funcionario p = new Funcionario("Fernando Silva",123,c,1412.0f,100.0f);
        Dependente p1 = new Dependente("João Srbek",1,c,17);
        Dependente p2 = new Dependente("Caua Moreno",2,c,18);
        Dependente p3 = new Dependente("Pedro Moreno Srbek",3,c,19);
        p.addDependentes(p1);
        p.addDependentes(p2);
        p.addDependentes(p3);
        Filial f = new Filial(new Historico());
        f.setCoordenadorLocal(p);
        assertEquals(3,f.qtdDependentesCoordenadorLocal());
    }

    //Consulta 9
    @Test
    void deveRetornarQtdDependentesAbonadosCoordenador(){
        Cidade c = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR")));
        Funcionario p = new Funcionario("Fernando Silva",123,c,1412.0f,100.0f);
        Dependente p1 = new Dependente("João Srbek",1,c,17);
        Dependente p2 = new Dependente("Caua Moreno",2,c,18);
        Dependente p3 = new Dependente("Pedro Moreno Srbek",3,c,19);
        Filial f = new Filial(new Historico());
        p.addDependentes(p1);
        p.addDependentes(p2);
        p.addDependentes(p3);
        f.setCoordenadorLocal(p);
        assertEquals(2,f.qtdDepsAbonoCoordenadorLocal());
    }

    //Consulta 19
    @Test
    void deveImprimirApenasDiscriminativo(){
        Historico h = new Historico();
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 1.5f);
        Cidade c = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR")));
        Empresa e = new Empresa("Empresa 1", 456, c,  0);
        Parceiro j = new Parceiro("Empresa 2",1,c,0);
        vendaAtacado g = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, j, e);
        h.addOcorrencia(v);
        h.addOcorrencia(g);
        Filial f = new Filial(h);
        assertEquals("Folha de Pagamento do Mês de Maio\nVenda de Lote de PCS\n",f.imprimirApenasDiscriminativo());
    }

    //Consultas 20

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
        Empresa e = new Empresa("Empresa 1", 456, c,  0);
        Parceiro j = new Parceiro("Empresa 2",1,c,0);
        vendaAtacado g = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, j, e);
        h.addOcorrencia(v);
        h.addOcorrencia(g);
        Filial f = new Filial(h);
        assertEquals(423f,f.obterLucroFinal());
    }
}