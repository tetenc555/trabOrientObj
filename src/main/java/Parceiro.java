public class Parceiro extends Pessoa{
    private int anosParceria;

    public Parceiro(String nome, int ID, Cidade cidade, int anosParceria) {
        super(nome, ID, cidade);
        this.setAnosParceria(anosParceria);
    }

    public int getAnosParceria() {
        return anosParceria;
    }

    public void setAnosParceria(int anosParceria) {
        if (anosParceria < 0) {
            throw new IllegalArgumentException("Anos de parceria inválido!");
        }
        this.anosParceria = anosParceria;
    }
}
