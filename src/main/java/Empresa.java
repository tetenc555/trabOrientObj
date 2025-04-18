import java.util.ArrayList;

public class Empresa extends Pessoa {
    private float lucroAtual;
    private float lucroMedioAnterior;
    private ArrayList<Filial> filiais;


    public Empresa(String nome, int ID, Cidade cidade, float lucroMedioAnterior) {
        super(nome, ID, cidade);
        this.setLucroAtual(0);
        this.lucroMedioAnterior = lucroMedioAnterior;
        this.filiais = new ArrayList<>();
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

    public void addFilial(Filial f) {
        filiais.add(f);
    }

    public ArrayList<Filial> getFiliais() {
        return filiais;
    }

    public void removerFilial (Filial f) {
        filiais.remove(f);
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

        //calculo diferenca
        float diferenca = lucroAtual - lucroMedioAnterior;
        diferenca = ((Math.round(diferenca * 100.0f)) / 100.0f);
        //retorno
        if (diferenca == 0.0f){
            return "Não houve mudança entre os dois períodos";
        }
        else if (diferenca > 0){
            return ("Em comparação ao período anterior, foi obtido lucro de R$" + diferenca);
        }
        else {
            return ("Em comparação ao período anterior, foi obtido prejuízo de R$" + (diferenca*-1)); //ajuste de sinal p impressao co9rreta
        }
    }

}
