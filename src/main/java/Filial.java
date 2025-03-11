public class Filial {
    private Funcionario coordenadorLocal;
    private Historico historico;
    public Filial(Historico historico){
        this.setHistorico(historico);
    }

    public Funcionario getCoordenadorLocal() {
        if (coordenadorLocal == null) {
            throw new IllegalArgumentException("Não há coordenador local na Filial!"); //como não é obrigatório, precisa de verificação no get.
        }
        return coordenadorLocal;
    }

    public void setCoordenadorLocal(Funcionario coordenadorLocal) {
        this.coordenadorLocal = coordenadorLocal; //eh possivel ser nulo, coordenadorLocal não é obrigatório.
    }

    public Historico getHistorico() {
        return historico;
    }

    public void setHistorico(Historico historico) {
        if (historico == null) {
            throw new NullPointerException("Filial deve possuir histórico!");
        }
        this.historico = historico;
    }

    public String imprimirHistorico() {
        return this.getHistorico().imprimirDetalhado();
    }

    public String imprimirApenasDiscriminativo(){
        return this.getHistorico().imprimirDescricoes();
    }

    public float obterLucroFinal(){
        return this.getHistorico().calcularLucroFinal();
    }

    public int qtdDependentesCoordenadorLocal(){
        return this.getCoordenadorLocal().quantDeps();
    }

    public int qtdDepsAbonoCoordenadorLocal(){
        return this.getCoordenadorLocal().quantDepAbono();
    }
}
