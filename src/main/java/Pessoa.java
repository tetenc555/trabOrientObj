public abstract class Pessoa {
    private String nome;
    private int ID;
    private Cidade cidade;

    public Pessoa(String nome, int ID, Cidade cidade) {
        this.setNome(nome);
        this.setID(ID);
        this.setCidade(cidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Pessoa deve ter nome.");
        }
        this.nome = nome;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        if (ID <= 0){
            throw new IllegalArgumentException("Pessoa deve ter ID maior que 0 para que seja válido.");
        }
        this.ID = ID;
    }

    public void setCidade(Cidade cidade) {
        if (cidade == null) {
            throw new NullPointerException("Pessoa deve ter cidade.");
        }
        this.cidade = cidade;
    }

    public String retornarNomeCidade(){
        return this.cidade.getNome();
    }

    public String retornarSiglaCidade(){
        return this.cidade.getSigla();
    }

    public String retornarNomeEstado(){
        return this.cidade.retornarNomeEstado();
    }

    public String retornarSiglaEstado(){
        return this.cidade.retornarSiglaEstado();
    }

    public String retornarNomePais(){
        return this.cidade.retornarNomePais();
    }

    public String retornarSiglaPais(){
        return this.cidade.retornarSiglaPais();
    }
}
