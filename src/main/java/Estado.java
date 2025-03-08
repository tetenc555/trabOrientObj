public class Estado {
    private String nome;
    private String sigla;
    private Pais pais;
    public Estado(String nome, String sigla, Pais pais) {
        this.setNome(nome);
        this.setSigla(sigla);
        this.setPais(pais);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Estado deve possuir um nome.");
        }
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        if (sigla == null || sigla.isEmpty()) {
            throw new IllegalArgumentException("Estado deve possuir uma sigla.");
        }
        this.sigla = sigla;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        if (pais == null) {
            throw new NullPointerException("Estado deve possuir um pais.");
        }
        this.pais = pais;
    }

    public String getNomePais(){
        return pais.getNome();
    }

    public String getSiglaPais(){
        return pais.getSigla();
    }
}
