public abstract class Ocorrencia {
    private float valor;
    private String descricao;
    private boolean tipo;

    public Ocorrencia(String descricao, boolean tipo) {
        this.calcularValorFinal();
        this.setDescricao(descricao);
        this.setTipo(tipo);
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        if (valor <=0.0f){
            throw new IllegalArgumentException("Valor da ocorrência inválido!");
        }
        this.valor = valor;
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
