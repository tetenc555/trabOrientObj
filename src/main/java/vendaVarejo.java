public class vendaVarejo extends OcorrenciaProduto{
    private Cliente destinatario;
    private Empresa remetente;

    public vendaVarejo(String descricao, int estoque, int qtdOcorrencia, float valorUnitario, Cliente destinatario, Empresa remetente) {
        super(descricao, true, estoque, qtdOcorrencia, valorUnitario);
        this.setDestinatario(destinatario);
        this.setRemetente(remetente);
        this.getDestinatario().adicionarCompra();
    }

    public Empresa getRemetente() {
        return remetente;
    }

    public void setRemetente(Empresa remetente) {
        if (remetente == null) {
            throw new NullPointerException("Deve possuir um remetente!");
        }
        this.remetente = remetente;
    }

    public Cliente getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Cliente destinatario) {
        if (destinatario == null) {
            throw new NullPointerException("Deve possuir um destinatário!");
        }
        this.destinatario = destinatario;
    }

    public float calcularDesconto(){
        float desconto = 0f;
        if (this.getDestinatario().isCartaoFidelidade()){
            desconto +=0.10f;
        }
        desconto += 0.02f * (((this.getDestinatario().getQtdCompras())-1)/10); //ajuste pois nao conta o item somado !
        return desconto;
    }

    public String retornarLocalEntrega(){
        return ("O endereço de destinatário é a Cidade " + this.getDestinatario().retornarNomeCidade() + " no estado de " + this.getDestinatario().retornarNomeEstado() + " - " + this.getDestinatario().retornarSiglaPais());
    }

    public String retornarLocalRemetente(){
        return ("O endereço do remetente é a Cidade " + this.getRemetente().retornarNomeCidade() + " no estado de " + this.getRemetente().retornarNomeEstado() + " - " + this.getRemetente().retornarSiglaPais());
    }
}
