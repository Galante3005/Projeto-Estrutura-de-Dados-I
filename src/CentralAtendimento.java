public class CentralAtendimento {
    private Fila<Solicitacoes> filaAguardando;
    private int proximoCodigo;
    public CentralAtendimento(int capacidadeFila){
       this.filaAguardando = new Fila<>(capacidadeFila);
       this.proximoCodigo = 1;
    }
    public Solicitacoes cadastrarSolicitacao(String solicitante,String descricao, String categoria,int prioridade){
    Solicitacoes novaSolicitacao = new Solicitacoes(proximoCodigo, solicitante, descricao, categoria, prioridade);
    filaAguardando.inserir(novaSolicitacao);
    proximoCodigo = proximoCodigo + 1;
    return novaSolicitacao;
    }
    public Solicitacoes consultarProxSolicitacao() {
    return filaAguardando.consultarProximo();
    }
    public boolean filaEstaVazia(){
        return filaAguardando.estaVazia();
    }
    public int getQuantidadeAguardando(){
       return filaAguardando.getQuantidade();
    }


}



