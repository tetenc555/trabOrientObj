public abstract class Ocorrencia {
    private String descricao;
    private boolean tipo;

    public Ocorrencia(String descricao, boolean tipo) {
        this.setDescricao(descricao);
        this.setTipo(tipo);
        //this.setValorFinal(this.calcularValorFinal());
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public abstract float calcularValorFinal();
}
