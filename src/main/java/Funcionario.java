import java.util.ArrayList;

public class Funcionario extends Pessoa{
    private float salarioBase;
    private float descontos;
    private ArrayList<Dependente> dependentes;

    public Funcionario(String nome, int ID, Cidade cidade, float salarioBase, float descontos) {
        super(nome, ID, cidade);
        this.salarioBase = salarioBase;
        this.descontos = descontos;
        this.dependentes = new ArrayList<Dependente>();
    }

    public float getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(float salarioBase) {
        if (salarioBase < 1412.0f) {
            throw new IllegalArgumentException("Salário invalido! Deve ser pelo menos o mínimo.");
        }
        this.salarioBase = salarioBase;
    }

    public float getDescontos() {
        return descontos;
    }

    public void setDescontos(float descontos) {
        if (descontos < 0.0f) {
            throw new IllegalArgumentException("Desconto inválido.");
        }
        this.descontos = descontos;
    }

    public void addDependentes(Dependente dependente) {
        this.dependentes.add(dependente);
    }

    public int quantDepAbono(){
        int quantidadeDependentesAbonados = 0;
        for (Dependente dependente : dependentes) {
            if (dependente.getIdade()<=18){
                quantidadeDependentesAbonados++;
            }
        }
        return quantidadeDependentesAbonados;
    }
}
