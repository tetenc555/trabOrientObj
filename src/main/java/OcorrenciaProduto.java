public abstract class OcorrenciaProduto extends Ocorrencia{
    private int estoque;
    private int qtdOcorrencia;
    private float valorUnitario;

    public OcorrenciaProduto(String descricao, boolean tipo, int estoque, int qtdOcorrencia, float valorUnitario) {
        super(descricao, tipo);
        this.estoque = estoque;
        this.qtdOcorrencia = qtdOcorrencia;
        this.valorUnitario = valorUnitario;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException("Estoque inválido!");
        }
        if (estoque == 0) {
            throw new IllegalArgumentException("Estoque vazio!");
        }
        this.estoque = estoque;
    }

    public int getQtdOcorrencia() {
        return qtdOcorrencia;
    }

    public void setQtdOcorrencia(int qtdOcorrencia) {
        if (qtdOcorrencia <= 0) {
            throw new IllegalArgumentException("Quantidade de itens da ocorrência inválida!");
        }
        this.qtdOcorrencia = qtdOcorrencia;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        if (valorUnitario <= 0) {
            throw new IllegalArgumentException("Valor unitário inválido!");
        }
        this.valorUnitario = valorUnitario;
    }

    public boolean vendaEhPossivel(){
        return this.getEstoque() >= this.getQtdOcorrencia();
    }

    public float calcularValorFinal() {
        if (!vendaEhPossivel())
        {
            throw new IllegalArgumentException("Não há estoque suficiente!");
        }
        float total = this.getQtdOcorrencia() * this.getValorUnitario();
        this.setEstoque(this.getEstoque() - this.getQtdOcorrencia());
        total -= total*this.calcularDesconto();
        total = (Math.round(total*100f))/100f;
        return total;
    }

    public abstract String retornarLocalEntrega();

    public abstract String retornarLocalRemetente();

    public abstract float calcularDesconto();
}
