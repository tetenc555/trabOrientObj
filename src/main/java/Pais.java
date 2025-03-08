public class Pais {
    private String nome;
    private String sigla;

    public Pais(String nome, String sigla) {
        this.setNome(nome);
        this.setSigla(sigla);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("País deve possuir um nome.");
        }
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        if (sigla == null || sigla.isEmpty()) {
            throw new IllegalArgumentException("Sigla deve possuir um nome.");
        }
        this.sigla = sigla;
    }
}
