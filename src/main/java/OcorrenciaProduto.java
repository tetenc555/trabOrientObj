public abstract class OcorrenciaProduto extends Ocorrencia{
    private int estoqueAtual;
    private int qtdOcorrencia;
    private float valorUnitario;

    public OcorrenciaProduto(String descricao, boolean tipo, int estoqueAtual, int qtdOcorrencia, float valorUnitario) {
        super(descricao, tipo);
        this.setEstoqueAtual(estoqueAtual);
        this.setQtdOcorrencia(qtdOcorrencia);
        this.setValorUnitario(valorUnitario);
    }

    public int getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(int estoqueAtual) {
        if (estoqueAtual < 0) {
            throw new IllegalArgumentException("Estoque inválido!");
        }
        this.estoqueAtual = estoqueAtual;
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
        return this.getEstoqueAtual() >= this.getQtdOcorrencia();
    }

    public float calcularValorFinal() {
        if (!vendaEhPossivel())
        {
            throw new IllegalArgumentException("Não há estoque suficiente!");
        }
        float total = this.getQtdOcorrencia() * this.getValorUnitario();
        total -= total*this.calcularDesconto();
        total = (Math.round(total*100f))/100f;
        return total;
    }

    public abstract String retornarLocalEntrega();

    public abstract String retornarLocalRemetente();

    public abstract float calcularDesconto();
}
