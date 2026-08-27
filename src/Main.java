public class Main {
    public static void main(String[] args) {
    Solicitacoes solicitacao = new Solicitacoes(101, "Ana", "A impressora não liga", "impressora", 2);
    System.out.println(solicitacao.getSolicitante());
    System.out.println(solicitacao.getStatus());
    System.out.println(solicitacao.getCodigo());
    System.out.println(solicitacao.getPrioridade());
    System.out.println(solicitacao.getResponsavel());
    System.out.println(solicitacao.getDataHoraAbertura());




    }
}
