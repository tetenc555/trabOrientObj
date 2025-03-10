import java.util.ArrayList;

public class Historico {
    private float lucroFinal;
    private ArrayList<Ocorrencia> ocorrencias;

    public Historico() {
        this.setLucroFinal(calcularLucroFinal());
        this.ocorrencias = new ArrayList<Ocorrencia>();
    }

    public float getLucroFinal() {
        return lucroFinal;
    }

    public void setLucroFinal(float lucroFinal) {
        this.lucroFinal = lucroFinal;
    }

    public ArrayList<Ocorrencia> getOcorrencias() {
        return ocorrencias;
    }

    public void addOcorrencia(Ocorrencia o) {
        this.ocorrencias.add(o);
    }

    public float calcularLucroFinal() {
        float lucroFinal = 0f;
        for (Ocorrencia o : ocorrencias) {
            lucroFinal+=o.retornarValorFinal();
        }
        return lucroFinal;
    }

    public String imprimirDescricoes() {
        String texto = "";
        for (Ocorrencia o : ocorrencias) {
            texto += o.getDescricao() + "\n";
        }
        return texto;
    }

    public String imprimirDetalhado() {
        String texto = "";
        for (Ocorrencia o : ocorrencias) {
            if (o.calcularValorFinal() == 0){
                texto += "Não houve mudança no faturamento";
            }
            else if (o.isLucro()) {
                texto += "Lucro de R$" + o.calcularValorFinal();
            }
            else{
                texto += "Prejuízo de R$" + o.calcularValorFinal();
            }
            if(o.getDescricao().isEmpty()){
                texto += "\n";
            }
            else{
                texto += " - " + o.getDescricao() + "\n";
            }
        }
        return texto;
    }
}
