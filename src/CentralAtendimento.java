public class CentralAtendimento {
    private Fila<Solicitacoes> filaAguardando;
    private int proximoCodigo;
    private Pilha<Operacao> historicoOperacoes;
    public CentralAtendimento(){
        this(100);
    }
    public CentralAtendimento(int capacidadeFila){
       this.filaAguardando = new Fila<>(capacidadeFila);
       this.historicoOperacoes = new Pilha<Operacao>(100);
       this.proximoCodigo = 1;
    }
    public Solicitacoes cadastrarSolicitacao(String solicitante,String descricao, String categoria,int prioridade){
        if (filaEstaCheia()) {
    throw new IllegalStateException(
            "Não é possível cadastrar: a fila está cheia."
    );
}

if (historicoEstaCheio()) {
    throw new IllegalStateException(
            "Não é possível cadastrar: o histórico está cheio."
    );
}
    Solicitacoes novaSolicitacao = new Solicitacoes(proximoCodigo, solicitante, descricao, categoria, prioridade);
    filaAguardando.inserir(novaSolicitacao);
    Operacao operacaoCadastro = new Operacao("CADASTRO", novaSolicitacao);
    historicoOperacoes.empilhar(operacaoCadastro);
    proximoCodigo = proximoCodigo + 1;
    return novaSolicitacao;
    }
    public Solicitacoes consultarProximaSolicitacao() {
    return filaAguardando.consultarProximo();
    }
    public boolean filaEstaVazia(){
        return filaAguardando.estaVazia();
    }
    public boolean filaEstaCheia() {
    return filaAguardando.estaCheia();
}
    public int getQuantidadeAguardando(){
       return filaAguardando.getQuantidade();
    }
    public Solicitacoes iniciarProximoAtendimento(String responsavel){
        if (filaEstaVazia()) {
    throw new IllegalStateException(
            "Não existem solicitações aguardando atendimento."
    );
}
if (historicoEstaCheio()) {
    throw new IllegalStateException(
            "Não é possível atender: o histórico está cheio."
    );
}
        Solicitacoes proxima;
        proxima = filaAguardando.consultarProximo();
        proxima.iniciarAtendimento(responsavel);
        filaAguardando.removerProximo();
        Operacao operacaoAtendimento = new Operacao("ATENDIMENTO", proxima);
        historicoOperacoes.empilhar(operacaoAtendimento);
        return proxima;
    }
    public String consultarFilaAguardando(){
        return filaAguardando.toString();
    }
    public Operacao consultarUltimaOperacao(){
        return historicoOperacoes.consultarTopo();
    }
    public boolean historicoEstaVazio(){
        return historicoOperacoes.estaVazia();
    }
    public boolean historicoEstaCheio() {
    return historicoOperacoes.estaCheia();
}
    public int getQuantidadeOperacoes(){
        return historicoOperacoes.getQuantidade();
    }
    public String exibirHistoricoOperacoes(){
        return historicoOperacoes.toString();
    }
    public Operacao removerUltimaOperacao(){
        return historicoOperacoes.desempilhar();
    }

}



