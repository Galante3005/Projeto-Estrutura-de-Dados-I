public class Operacao{
    private String tipo;
    private Solicitacoes solicitacao;

/* Valida se o tipo informado é um dos aceitos e se a solicitação
    associada não é nula, já que toda operação precisa estar ligada
    a uma solicitação real do sistema.
     */
    
public Operacao(String tipo, Solicitacoes solicitacao){

    if(tipo == null || tipo.isBlank()){
        throw new IllegalArgumentException("O tipo da operacao deve ser preenchido.");
    }
    if(!tipo.equals("CADASTRO") && !tipo.equals("ATENDIMENTO") && !tipo.equals("CANCELAMENTO")){
        throw new IllegalArgumentException("Tipo de operacao invalido.");
    }
    if(solicitacao == null){
        throw new IllegalArgumentException("A operacao deve ser associada a uma solicitacao");
    }
    
this.tipo = tipo;
this.solicitacao = solicitacao;
}

public String getTipo(){
    return this.tipo;
}

public Solicitacoes getSolicitacao(){
    return this.solicitacao;
}

/* Usado para exibir o histórico de forma legível no menu,
    mostrando o tipo da operação e o código da solicitação envolvida.
     */

@Override
public String toString() {
    return tipo + " - Solicitação " + solicitacao.getCodigo();
}   
}
