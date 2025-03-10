public abstract class OcorrenciaProduto extends Ocorrencia{
    private int estoque;
    private int qtdOcorrencia;
    private float valorUnitario;
    private Pessoa remetente;
    private Pessoa destinatario;

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
            throw new IllegalArgumentException("Quantidade de itens da ocorrência inválida!")
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

    public Pessoa getRemetente() {
        return remetente;
    }

    public void setRemetente(Pessoa remetente) {
        if (remetente == null) {
            throw new NullPointerException("Deve possuir um remetente!");
        }
        this.remetente = remetente;
    }

    public Pessoa getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Pessoa destinatario) {
        if (destinatario == null) {
            throw new NullPointerException("Deve possuir um destinatário!");
        }
        this.destinatario = destinatario;
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
        total = (Math.round(total*100f))/100f;
        return total;
    }

    public String retornarLocalEntrega(){
        return ("O endereço de destinatário é a Cidade " + this.destinatario.retornarNomeCidade() + " no estado de " + this.destinatario.retornarNomeEstado() + " - " + this.destinatario.retornarSiglaPais());
    }

    public String retornarLocalRemetente(){
        return ("O endereço do remetente é a Cidade " + this.remetente.retornarNomeCidade() + " no estado de " + this.remetente.retornarNomeEstado() + " - " + this.remetente.retornarSiglaPais());
    }

    public abstract float calcularDesconto();
}
