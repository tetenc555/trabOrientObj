public class Dependente extends Pessoa{
    private int idade;

    public Dependente(String nome, int ID, Cidade cidade, int idade) {
        super(nome, ID, cidade);
        this.setIdade(idade);
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade negativa é inválida!");
        }
        this.idade = idade;
    }
}
