import java.util.ArrayList;

public class Empresa extends Pessoa {
    private float lucroAtual;
    private float lucroMedioAnterior;
    private ArrayList<Filial> filiais;


    public Empresa(String nome, int ID, Cidade cidade, float lucroMedioAnterior) {
        super(nome, ID, cidade);
        this.setLucroAtual(0);
        this.lucroMedioAnterior = lucroMedioAnterior;
        this.filiais = new ArrayList<Filial>();
    }

    public float getLucroAtual() {
        return lucroAtual;
    }

    public void setLucroAtual(float lucroAtual) {
        this.lucroAtual = lucroAtual;
    }

    public float getLucroMedioAnterior() {
        return lucroMedioAnterior;
    }

    public void setLucroMedioAnterior(float lucroMedioAnterior) {
        this.lucroMedioAnterior = lucroMedioAnterior;
    }

    public void calcularLucroAtual(){
        float lucroTotal = 0.0f;
        for (Filial f : filiais){
            lucroTotal += f.obterLucroFinal();
        }
        this.setLucroAtual(lucroTotal);
    }

    public String comparacaoDeLucros(){
        float lucroAtual = this.getLucroAtual();
        float lucroMedioAnterior = this.getLucroMedioAnterior();
        //ajuste de sinais em variaveis locais para conta correta
        if (lucroAtual<0){
            lucroAtual = lucroAtual*-1;
        }
        if (lucroMedioAnterior<0){
            lucroMedioAnterior = lucroMedioAnterior*-1;
        }
        //retorno
        if (lucroAtual == lucroMedioAnterior){
            return "Não houve mudança entre os dois períodos";
        }
        else if (lucroAtual > lucroMedioAnterior){
            return ("Em comparação ao período anterior, foi obtido lucro de R$" + (lucroAtual-lucroMedioAnterior));
        }
        else {
            return ("Em comparação ao período anterior, foi obtido prejuízo de R$" + (lucroMedioAnterior-lucroAtual));
        }
    }

}
