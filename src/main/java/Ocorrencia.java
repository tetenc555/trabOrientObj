public abstract class Ocorrencia {
    private String descricao;
    private boolean lucro;

    public Ocorrencia(String descricao, boolean lucro) {
        this.setDescricao(descricao);
        this.setLucro(lucro);
    }

    public float retornarValorFinal() {
        if (this.isLucro()){
            return this.calcularValorFinal();
        }
        else {
            return -1 * this.calcularValorFinal();
        }
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao == null || descricao.isEmpty()){
            throw new IllegalArgumentException("Ocorrência deve possuir descrição!");
        }
        this.descricao = descricao;
    }

    public boolean isLucro() {
        return lucro;
    }

    public void setLucro(boolean lucro) {
        this.lucro = lucro;
    }

    public abstract float calcularValorFinal();
}
