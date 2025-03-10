public class Cliente extends Pessoa{
    private int qtdCompras;
    private boolean cartaoFidelidade;

    public Cliente(String nome, int ID, Cidade cidade) {
        super(nome, ID, cidade);
        this.setQtdCompras(0);
        this.setCartaoFidelidade(false);
    }

    public int getQtdCompras() {
        return qtdCompras;
    }

    public void setQtdCompras(int qtdCompras) {
        if (qtdCompras < 0 || qtdCompras > 52) {
            throw new IllegalArgumentException("Quantidade de Compras Inválida!");
        }
        if (qtdCompras == 52){
            this.qtdCompras = 1;
        }
        else{
            this.qtdCompras = qtdCompras;
        }
    }

    public boolean isCartaoFidelidade() {
        return cartaoFidelidade;
    }

    public void setCartaoFidelidade(boolean cartaoFidelidade) {
        this.cartaoFidelidade = cartaoFidelidade;
    }

    public String tornarFidelidade() {
        if (isCartaoFidelidade()) {
            throw new IllegalArgumentException("Já é fidelidade!");
        }
        this.setCartaoFidelidade(true);
        return (this.getNome() + " se tornou fidelidade!");
    }

    public void adicionarCompra(){
        this.setQtdCompras(this.getQtdCompras() + 1);
    }
}
