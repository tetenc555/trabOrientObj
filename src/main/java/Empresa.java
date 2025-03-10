import java.util.ArrayList;

public class Empresa extends Pessoa {
    private float lucroAtual;
    private float lucroMedioAnterior;
    //private ArrayList<Filial> filiais;


    public Empresa(String nome, int ID, Cidade cidade, float lucroAtual, float lucroMedioAnterior) {
        super(nome, ID, cidade);
        this.lucroAtual = lucroAtual;
        this.lucroMedioAnterior = lucroMedioAnterior;
        //this.filiais = new ArrayList<Filial>();
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

}
