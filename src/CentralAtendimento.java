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
    Solicitacoes novaSolicitacao = new Solicitacoes(proximoCodigo, solicitante, descricao, categoria, prioridade);
    filaAguardando.inserir(novaSolicitacao);
    Operacao operacaoCadastro = new Operacao("CADASTRO", novaSolicitacao);
    historicoOperacoes.empilhar(operacaoCadastro);
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
    public Solicitacoes iniciarProximoAtendimento(String responsavel){
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
    public int getQuantidadeOperacoes(){
        return historicoOperacoes.getQuantidade();
    }
}



