import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaTest {
    @Test
    void deveRetornarLucroAtual() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        assertEquals(0,e.getLucroAtual());
    }

    @Test
    void deveRetornarLucroAtualDefinido() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        e.setLucroAtual(2.5f);
        assertEquals(2.5f,e.getLucroAtual());
    }

    @Test
    void deveRetornarLucroAnterior() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  1.34f);
        assertEquals(1.34f,e.getLucroMedioAnterior());
    }

    @Test
    void deveAdicionarFilialEmpresa(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  1.34f);
        Filial f1 = new Filial(new Historico());
        Filial f2 = new Filial(new Historico());
        e.addFilial(f1);
        e.addFilial(f2);
        ArrayList<Filial> testar = new ArrayList<Filial>();
        testar.add(f1);
        testar.add(f2);
        assertEquals(testar,e.getFiliais());
    }

    @Test
    void deveRemoverFilialEmpresa(){
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  1.34f);
        Filial f1 = new Filial(new Historico());
        Filial f2 = new Filial(new Historico());
        e.addFilial(f1);
        e.addFilial(f2);
        ArrayList<Filial> testar = new ArrayList<Filial>();
        testar.add(f1);
        e.removerFilial(f2);
        assertEquals(testar,e.getFiliais());
    }

    @Test
    void deveObterLucroZeroSemFilial() {
        Cidade a = new Cidade("Juiz de Fora", "JF", new Estado("Minas Gerais", "MG", new Pais("Brasil", "BR")));
        Empresa e = new Empresa("Empresa 1", 456, a,  0);
        e.calcularLucroAtual();
        assertEquals(0,e.getLucroAtual());
    }

    @Test
    void comparacaoDeveRetornarLucroSeDiferencaPositivo(){
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
        Empresa m = new Empresa("Empresa 1", 456, c,  0);
        Parceiro j = new Parceiro("Empresa 2",1,c,0);
        vendaAtacado g = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, j, m);
        h.addOcorrencia(v);
        h.addOcorrencia(g);
        Filial f = new Filial(h);
        Empresa e = new Empresa("Empresa 1", 456, c,  422.9f);
        e.addFilial(f);
        e.calcularLucroAtual();
        assertEquals("Em comparação ao período anterior, foi obtido lucro de R$0.1",e.comparacaoDeLucros());
    }

    @Test
    void comparacaoDeveRetornarSemDiferenca(){
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
        Empresa m = new Empresa("Empresa 1", 456, c,  0);
        Parceiro j = new Parceiro("Empresa 2",1,c,0);
        vendaAtacado g = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, j, m);
        h.addOcorrencia(v);
        h.addOcorrencia(g);
        Filial f = new Filial(h);
        Empresa e = new Empresa("Empresa 1", 456, c,  423f);
        e.addFilial(f);
        e.calcularLucroAtual();
        assertEquals("Não houve mudança entre os dois períodos",e.comparacaoDeLucros());
    }

    @Test
    void comparacaoDeveRetornarPrejuizoSeDiferencaNegativo(){
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
        Empresa m = new Empresa("Empresa 1", 456, c,  0);
        Parceiro j = new Parceiro("Empresa 2",1,c,0);
        vendaAtacado g = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, j, m);
        h.addOcorrencia(v);
        h.addOcorrencia(g);
        Filial f = new Filial(h);
        Empresa e = new Empresa("Empresa 1", 456, c,  423.1f);
        e.addFilial(f);
        e.calcularLucroAtual();
        assertEquals("Em comparação ao período anterior, foi obtido prejuízo de R$0.1",e.comparacaoDeLucros());
    }

    //Consultas

    //Consulta 1
    @Test
    void deveRetornarEstadoNomeEmpresa(){
        Cidade c = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR")));
        Empresa e = new Empresa("Empresa 1", 456, c,  423.1f);
        assertEquals("Minas Gerais",e.retornarNomeEstado());
    }

    @Test
    void deveRetornarEstadoSiglaEmpresa(){
        Cidade c = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR")));
        Empresa e = new Empresa("Empresa 1", 456, c,  423.1f);
        assertEquals("MG",e.retornarSiglaEstado());
    }

    //Consulta 2
    @Test
    void deveSalvarLucroAtualPositivo(){
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
        Empresa m = new Empresa("Empresa 1", 456, c,  0);
        Parceiro j = new Parceiro("Empresa 2",1,c,0);
        vendaAtacado g = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, j, m);
        h.addOcorrencia(v);
        h.addOcorrencia(g);
        Filial f = new Filial(h);
        Empresa e = new Empresa("Empresa 1", 456, c,  200);
        e.addFilial(f);
        e.calcularLucroAtual();
        assertEquals(423f,e.getLucroAtual());
    }

    @Test
    void deveSalvarLucroAtualZero(){
        Historico h = new Historico();
        Cidade c = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR")));
        Funcionario p = new Funcionario("Fernando Silva",123,c,1412.0f,100.0f);
        Dependente p1 = new Dependente("João Srbek",1,c,17);
        Dependente p2 = new Dependente("Caua Moreno",2,c,18);
        Dependente p3 = new Dependente("Pedro Moreno Srbek",3,c,19);
        p.addDependentes(p1);
        p.addDependentes(p2);
        p.addDependentes(p3);
        Funcionario d = new Funcionario("Carlos",456,c,1835.0f,0.0f);
        Dependente d1 = new Dependente("Carlos Junior",4,c,17);
        d.addDependentes(d1);
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 1.5f);
        v.adicionarFuncionario(p);
        v.adicionarFuncionario(d);
        Empresa m = new Empresa("Empresa 1", 456, c,  0);
        Parceiro j = new Parceiro("Empresa 2",1,c,0);
        vendaAtacado g = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, j, m);
        h.addOcorrencia(v);
        h.addOcorrencia(g);
        Filial f = new Filial(h);
        Empresa e = new Empresa("Empresa 1", 456, c,  200);
        e.addFilial(f);
        e.calcularLucroAtual();
        assertEquals(0f,e.getLucroAtual());
    }

    @Test
    void deveSalvarLucroAtualNegativo(){
        Historico h = new Historico();
        Cidade c = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR")));
        Funcionario p = new Funcionario("Fernando Silva",123,c,1412.0f,100.0f);
        Dependente p1 = new Dependente("João Srbek",1,c,17);
        Dependente p2 = new Dependente("Caua Moreno",2,c,18);
        Dependente p3 = new Dependente("Pedro Moreno Srbek",3,c,19);
        p.addDependentes(p1);
        p.addDependentes(p2);
        p.addDependentes(p3);
        Funcionario d = new Funcionario("Carlos",456,c,1835.0f,0.0f);
        Dependente d1 = new Dependente("Carlos Junior",4,c,17);
        d.addDependentes(d1);
        Funcionario d2 = new Funcionario("Carlos Maneiro Soarez",456,c,1412.5f,411.5f);
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 1.5f);
        v.adicionarFuncionario(p);
        v.adicionarFuncionario(d);
        v.adicionarFuncionario(d2);
        Empresa m = new Empresa("Empresa 1", 456, c,  0);
        Parceiro j = new Parceiro("Empresa 2",1,c,0);
        vendaAtacado g = new vendaAtacado("Venda de Lote de PCS", 20, 2, 2000f, j, m);
        h.addOcorrencia(v);
        h.addOcorrencia(g);
        Filial f = new Filial(h);
        Empresa e = new Empresa("Empresa 1", 456, c,  200);
        e.addFilial(f);
        e.calcularLucroAtual();
        assertEquals(-1002.5f,e.getLucroAtual());
    }
}