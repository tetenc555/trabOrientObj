import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
//            Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
class FuncionarioTest {
    @Test
    void naoDeveDefinirNomeVazio() {
        try{
            Funcionario p = new Funcionario(null,123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
            fail();
        }
        catch (IllegalArgumentException e){
            assertEquals("Pessoa deve ter nome.",e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirIDNegativo() {
        try {
            Funcionario p = new Funcionario("Fernando Silva",0,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Pessoa deve ter ID maior que 0 para que seja válido.", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirCidadeVazia() {
        try{
            Funcionario p = new Funcionario("Fernando Silva",123,null,1412.0f,0.0f);
            fail();
        }
        catch (NullPointerException e){
            assertEquals("Pessoa deve ter cidade.", e.getMessage());
        }
    }

    @Test
    void deveRetornarNomeCliente() {
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
        assertEquals("Fernando Silva",p.getNome());
    }

    @Test
    void deveRetornarIDCliente() {
        Funcionario p = new Funcionario("Fernando Silva",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
        assertEquals(1,p.getID());
    }

    @Test
    void deveRetornarNomeCidade() {
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
        assertEquals("Juiz de Fora",p.retornarNomeCidade());
    }

    @Test
    void deveRetornarSiglaCidade() {
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
        assertEquals("JF",p.retornarSiglaCidade());
    }

    @Test
    void deveRetornarNomeEstado() {
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
        assertEquals("Minas Gerais",p.retornarNomeEstado());
    }

    @Test
    void deveRetornarSiglaEstado() {
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
        assertEquals("MG",p.retornarSiglaEstado());
    }

    @Test
    void deveRetornarNomePais() {
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
        assertEquals("Brasil",p.retornarNomePais());
    }

    @Test
    void deveRetornarSiglaPais() {
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
        assertEquals("BR",p.retornarSiglaPais());
    }

    //testes envolvendo apenas funcionario

    @Test
    void naoDeveDefinirSalarioBaseAbaixoMinimo(){
        try{
            Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1411.99f,0.0f);
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("Salário invalido! Deve ser pelo menos o mínimo.", e.getMessage());
        }
    }

    @Test
    void naoDeveDefinirDescontoNegativo(){
        try{
            Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,-0.1f);
            fail();
        }
        catch(IllegalArgumentException e){
            assertEquals("Desconto inválido.",e.getMessage());
        }
    }

    @Test
    void deveDefinirSalarioMinimo(){
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
        assertEquals(1412.0f,p.getSalarioBase());
    }

    @Test
    void deveDefinirDescontoZero(){
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
        assertEquals(0f,p.getDescontos());
    }

    @Test
    void deveAdicionarDependente(){
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
        Dependente p1 = new Dependente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),17);
        Dependente p2 = new Dependente("Caua Moreno",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),18);
        Dependente p3 = new Dependente("Pedro Moreno Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),19);
        p.addDependentes(p1);
        p.addDependentes(p2);
        p.addDependentes(p3);
        ArrayList<Dependente> teste = new ArrayList<Dependente>();
        teste.add(p1);
        teste.add(p2);
        teste.add(p3);
        assertEquals(teste,p.getDependentes());
    }

    @Test
    void deveRetornarQuantidadeDependentes(){
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
        Dependente p1 = new Dependente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),17);
        Dependente p2 = new Dependente("Caua Moreno",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),18);
        Dependente p3 = new Dependente("Pedro Moreno Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),19);
        p.addDependentes(p1);
        p.addDependentes(p2);
        p.addDependentes(p3);
        assertEquals(3,p.quantDeps());
    }

    @Test
    void deveRetornarQuantidadeDependentesAbonados(){ //aqui também é testado addDependentes
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
        Dependente p1 = new Dependente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),17);
        Dependente p2 = new Dependente("Caua Moreno",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),18);
        Dependente p3 = new Dependente("Pedro Moreno Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),19);
        p.addDependentes(p1);
        p.addDependentes(p2);
        p.addDependentes(p3);
        assertEquals(2,p.quantDepAbono());
    }

    @Test
    void deveCalcularSalarioBasico(){
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
        assertEquals(1412.0f,p.calcularSalarioIndividual());
    }

    @Test
    void deveCalcularSalarioComDesconto(){
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,100.0f);
        assertEquals(1312.0f,p.calcularSalarioIndividual());
    }

    @Test
    void deveCalcularSalarioComDependetesAbonados(){
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,0.0f);
        Dependente p1 = new Dependente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),17);
        Dependente p2 = new Dependente("Caua Moreno",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),18);
        Dependente p3 = new Dependente("Pedro Moreno Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),19);
        p.addDependentes(p1);
        p.addDependentes(p2);
        p.addDependentes(p3);
        assertEquals(1712.0f,p.calcularSalarioIndividual());
    }

    @Test
    void deveCalcularSalarioComDependetesAbonadosDesconto(){
        Funcionario p = new Funcionario("Fernando Silva",123,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),1412.0f,100.0f);
        Dependente p1 = new Dependente("João Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),17);
        Dependente p2 = new Dependente("Caua Moreno",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),18);
        Dependente p3 = new Dependente("Pedro Moreno Srbek",1,new Cidade ("Juiz de Fora", "JF",new Estado("Minas Gerais", "MG", new Pais("Brasil","BR"))),19);
        p.addDependentes(p1);
        p.addDependentes(p2);
        p.addDependentes(p3);
        assertEquals(1612.0f,p.calcularSalarioIndividual());
    }
}