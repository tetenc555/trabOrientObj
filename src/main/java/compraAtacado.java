public class compraAtacado extends OcorrenciaProduto{
    private Empresa destinatario;
    private Parceiro remetente;

    public compraAtacado(String descricao, int estoque, int qtdOcorrencia, float valorUnitario, Empresa destinatario, Parceiro remetente) {
        super(descricao, false, estoque, qtdOcorrencia, valorUnitario);
        this.setDestinatario(destinatario);
        this.setRemetente(remetente);
    }

    public Parceiro getRemetente() {
        return remetente;
    }

    public void setRemetente(Parceiro remetente) {
        if (remetente == null) {
            throw new NullPointerException("Deve possuir um remetente!");
        }
        this.remetente = remetente;
    }

    public Empresa getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Empresa destinatario) {
        if (destinatario == null) {
            throw new NullPointerException("Deve possuir um destinatário!");
        }
        this.destinatario = destinatario;
    }

    public float calcularDesconto(){
        float desconto =0.1f;
        if (this.getRemetente().getAnosParceria() >= 5) {
            desconto += 0.1f;
        }
        else{
            desconto += 0.02f * this.getRemetente().getAnosParceria();
        }
        return desconto ;
    }

    public String retornarLocalEntrega(){
        return ("O endereço de destinatário é a Cidade " + this.getDestinatario().retornarNomeCidade() + " no estado de " + this.getDestinatario().retornarNomeEstado() + " - " + this.getDestinatario().retornarSiglaPais());
    }

    public String retornarLocalRemetente(){
        return ("O endereço do remetente é a Cidade " + this.getRemetente().retornarNomeCidade() + " no estado de " + this.getRemetente().retornarNomeEstado() + " - " + this.getRemetente().retornarSiglaPais());
    }

    public String retornarNomeCidadeDestinatario(){
        return this.getDestinatario().retornarNomeCidade();
    }

    public String retornarNomeEstadoDestinatario(){
        return this.getDestinatario().retornarNomeEstado();
    }

    public String retornarNomePaisDestinatario(){
        return this.getDestinatario().retornarNomePais();
    }

    public String retornarNomeCidadeRemetente(){
        return this.getRemetente().retornarNomeCidade();
    }

    public String retornarNomeEstadoRemetente(){
        return this.getRemetente().retornarNomeEstado();
    }

    public String retornarNomePaisRemetente(){
        return this.getRemetente().retornarNomePais();
    }
}
