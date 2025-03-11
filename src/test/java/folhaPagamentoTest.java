import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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

    //testes especificos a folhaPagamento

    @Test
    void naoDeveDefinirValorBonusNegativo() {
        try {
            folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", -0.1f);
        }
        catch (IllegalArgumentException e) {
            assertEquals("Valor bonus inválido!",e.getMessage());
        }
    }

    @Test
    void deveDefinirValorBonusZero(){
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 0f);
        assertEquals(0f,v.getValorBonus());
    }

    @Test
    void deveAdicionarFuncionario() {
        Cidade c = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR")));
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 0f);
        Funcionario p = new Funcionario("Fernando Silva",123,c,1412.0f,0.0f);
        Funcionario p2 = new Funcionario("Fernando Soares",123,c,1413.0f,0.0f);
        v.adicionarFuncionario(p);
        v.adicionarFuncionario(p2);
        ArrayList<Funcionario> teste = new ArrayList<Funcionario>();
        teste.add(p);
        teste.add(p2);
        assertEquals(teste,v.getFuncionariosPagar());
    }

    @Test
    void deveCalcularValorSemBonus(){
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
        Dependente d2 = new Dependente("João Deftones",5,c,18);
        Dependente d3 = new Dependente("Vitória Derrotas",6,c,19);
        d.addDependentes(d1);
        d.addDependentes(d2);
        d.addDependentes(d3);
        Funcionario k = new Funcionario("Fernanda FiberHome da Silova",789,c,1412.0f,100.0f);
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 0f);
        v.adicionarFuncionario(p);
        v.adicionarFuncionario(d);
        v.adicionarFuncionario(k);
        assertEquals(4636.0f,v.calcularValorFinal());
    }

    @Test
    void deveRetornarValorSemBonusNegativo(){
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
        Dependente d2 = new Dependente("João Deftones",5,c,18);
        Dependente d3 = new Dependente("Vitória Derrotas",6,c,19);
        d.addDependentes(d1);
        d.addDependentes(d2);
        d.addDependentes(d3);
        Funcionario k = new Funcionario("Fernanda FiberHome da Silova",789,c,1412.0f,100.0f);
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 0f);
        v.adicionarFuncionario(p);
        v.adicionarFuncionario(d);
        v.adicionarFuncionario(k);
        assertEquals(-4636.0f,v.retornarValorFinal());
    }

    @Test
    void deveCalcularValorComBonus(){
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
        Dependente d2 = new Dependente("João Deftones",5,c,18);
        Dependente d3 = new Dependente("Vitória Derrotas",6,c,19);
        d.addDependentes(d1);
        d.addDependentes(d2);
        d.addDependentes(d3);
        Funcionario k = new Funcionario("Fernanda FiberHome da Silova",789,c,1412.0f,100.0f);
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 1.5f);
        v.adicionarFuncionario(p);
        v.adicionarFuncionario(d);
        v.adicionarFuncionario(k);
        assertEquals(4640.5f,v.calcularValorFinal());
    }

    @Test
    void deveRetornarValorComBonusNegativo(){
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
        Dependente d2 = new Dependente("João Deftones",5,c,18);
        Dependente d3 = new Dependente("Vitória Derrotas",6,c,19);
        d.addDependentes(d1);
        d.addDependentes(d2);
        d.addDependentes(d3);
        Funcionario k = new Funcionario("Fernanda FiberHome da Silova",789,c,1412.0f,100.0f);
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 1.5f);
        v.adicionarFuncionario(p);
        v.adicionarFuncionario(d);
        v.adicionarFuncionario(k);
        assertEquals(-4640.5f,v.retornarValorFinal());
    }

    //Consultas

    //Consulta 4
    @Test
    void deveRetornarQtdDependentesRegistrados(){
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
        Dependente d2 = new Dependente("João Deftones",5,c,18);
        Dependente d3 = new Dependente("Vitória Derrotas",6,c,19);
        d.addDependentes(d1);
        d.addDependentes(d2);
        d.addDependentes(d3);
        Funcionario k = new Funcionario("Fernanda FiberHome da Silova",789,c,1412.0f,100.0f);
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 1.5f);
        v.adicionarFuncionario(p);
        v.adicionarFuncionario(d);
        v.adicionarFuncionario(k);
        assertEquals(6,v.qtdDependentes());
    }

    //Consulta 5
    @Test
    void deveRetornarQtdDependentesAbonados(){
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
        Dependente d2 = new Dependente("João Deftones",5,c,18);
        Dependente d3 = new Dependente("Vitória Derrotas",6,c,19);
        d.addDependentes(d1);
        d.addDependentes(d2);
        d.addDependentes(d3);
        Funcionario k = new Funcionario("Fernanda FiberHome da Silova",789,c,1412.0f,100.0f);
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 1.5f);
        v.adicionarFuncionario(p);
        v.adicionarFuncionario(d);
        v.adicionarFuncionario(k);
        assertEquals(4,v.qtdDepsAbono());
    }

    //Consulta 10

    @Test
    void deveRemoverTodosFuncionarios(){
        Cidade c = new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR")));
        folhaPagamento v = new folhaPagamento("Folha de Pagamento do Mês de Maio", 0f);
        Funcionario p = new Funcionario("Fernando Silva",123,c,1412.0f,0.0f);
        Funcionario p2 = new Funcionario("Fernando Soares",123,c,1413.0f,0.0f);
        v.adicionarFuncionario(p);
        v.adicionarFuncionario(p2);
        v.removerTodosFuncionarios();
        assertTrue(v.getFuncionariosPagar().isEmpty());
    }

}