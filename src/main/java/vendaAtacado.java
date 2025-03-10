public class vendaAtacado  extends OcorrenciaProduto{
    private Parceiro destinatario;
    private Empresa remetente;

    public vendaAtacado(String descricao, int estoque, int qtdOcorrencia, float valorUnitario, Parceiro destinatario, Empresa remetente) {
        super(descricao, false, estoque, qtdOcorrencia, valorUnitario);
        this.setDestinatario(destinatario);
        this.setRemetente(remetente);
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

    public Parceiro getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Parceiro destinatario) {
        if (destinatario == null) {
            throw new NullPointerException("Deve possuir um destinatário!");
        }
        this.destinatario = destinatario;
    }

    public float calcularDesconto(){
        float desconto =0.1f;
        if (this.getDestinatario().getAnosParceria() >= 5) {
            desconto += 0.1f;
        }
        else{
            desconto += 0.02f * this.getDestinatario().getAnosParceria();
        }
        return desconto ;
    }

    public String retornarLocalEntrega(){
        return ("O endereço de destinatário é a Cidade " + this.getDestinatario().retornarNomeCidade() + " no estado de " + this.getDestinatario().retornarNomeEstado() + " - " + this.getDestinatario().retornarSiglaPais());
    }

    public String retornarLocalRemetente(){
        return ("O endereço do remetente é a Cidade " + this.getRemetente().retornarNomeCidade() + " no estado de " + this.getRemetente().retornarNomeEstado() + " - " + this.getRemetente().retornarSiglaPais());
    }
