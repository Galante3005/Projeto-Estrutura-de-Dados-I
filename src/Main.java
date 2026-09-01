/* o main até o momento pode ignorar, eu to utilizando ele só para
fazer os testes das funções que eu to implementando.
 */


public class Main {
    public static void main(String[] args) {
        Fila<Solicitacoes> fila = new Fila<>(10);

        Solicitacoes solicitacao = new Solicitacoes(
                101,
                "Ana",
                "A impressora não liga",
                "Impressora",
                2
        );

        System.out.println("Fila vazia antes da inserção: "
                + fila.estaVazia());

        fila.inserir(solicitacao);
        Solicitacoes proxima = fila.consultarProximo();

        System.out.println(
                "Próximo solicitante: " + proxima.getSolicitante()
        );

        System.out.println(
                "Quantidade após consultar: " + fila.getQuantidade()
        );

        System.out.println("Fila vazia depois da inserção: "
                + fila.estaVazia());
    }
}