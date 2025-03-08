public class Cidade {
    private String nome;
    private String sigla;
    private Estado estado;
    public Cidade(String nome, String sigla, Estado estado) {
        this.setNome(nome);
        this.setSigla(sigla);
        this.setEstado(estado);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Cidade deve possuir um nome.");
        }
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        if (sigla == null || sigla.isEmpty()) {
            throw new IllegalArgumentException("Cidade deve possuir uma sigla.");
        }
        this.sigla = sigla;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        if (estado == null) {
            throw new NullPointerException("Cidade deve possuir um estado.");
        }
        this.estado = estado;
    }

    public String retornarNomeEstado(){
        return this.estado.getNome();
    }

    public String retornarSiglaEstado(){
        return this.estado.getSigla();
    }

    public String retornarNomePais(){
        return this.estado.retornarNomePais();
    }

    public String retornarSiglaPais(){
        return this.estado.retornarSiglaPais();
    }
}
