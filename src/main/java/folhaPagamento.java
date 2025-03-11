import java.util.ArrayList;

public class folhaPagamento extends Ocorrencia{
    private float valorBonus;
    private ArrayList<Funcionario> funcionariosPagar;

    public folhaPagamento(String descricao, float valorBonus) {
        super(descricao, false);
        this.setValorBonus(valorBonus);
        this.funcionariosPagar = new ArrayList<Funcionario>();
    }

    public float getValorBonus() {
        return valorBonus;
    }

    public void setValorBonus(float valorBonus) {
        if (valorBonus < 0) {
            throw new IllegalArgumentException("Valor bonus inválido!");
        }
        this.valorBonus = valorBonus;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionariosPagar.add(funcionario);
    }

    public ArrayList<Funcionario> getFuncionariosPagar() {
        return funcionariosPagar;
    }

    public void removerTodosFuncionarios(){
        funcionariosPagar.removeAll(funcionariosPagar);
    }

    public float calcularValorFinal(){
        float valorTotal = 0;
        for (Funcionario funcionario : funcionariosPagar) {
            valorTotal+= funcionario.calcularSalarioIndividual() + this.getValorBonus();
        }
        valorTotal = (Math.round(valorTotal * 100f) / 100f);
        return valorTotal;
    }

    public int qtdDependentes(){
        int qtdDependentes = 0;
        for (Funcionario funcionario : funcionariosPagar) {
            qtdDependentes+=funcionario.quantDeps();
        }
        return qtdDependentes;
    }

    public int qtdDepsAbono(){
        int qtdDependentes = 0;
        for (Funcionario funcionario : funcionariosPagar) {
            qtdDependentes+=funcionario.quantDepAbono();
        }
        return qtdDependentes;
    }
}
