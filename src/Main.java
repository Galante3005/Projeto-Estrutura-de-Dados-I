import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        CentralAtendimento central = new CentralAtendimento(); // ajuste aqui se o construtor pedir capacidade da Fila/Pilha

        String[] nomes = {
            "Rafael Martins", "Beatriz Alves", "Thiago Nogueira", "Camila Duarte", "Lucas Pereira",
            "Fernanda Ramos", "Rodrigo Teixeira", "Juliana Brito", "Marcos Vinícius", "Patrícia Gomes"
        };
        String[] descricoes = {
            "Sinal de internet caindo toda hora", "Fatura com valor divergente", "Aplicativo travando ao abrir",
            "Solicitação de segunda via de boleto", "Equipamento com defeito de fábrica",
            "Cobrança de serviço não contratado", "Lentidão no atendimento pelo chat", "Erro no cadastro do cliente",
            "Pedido de cancelamento de plano", "Falha na instalação do serviço"
        };
        String[] categorias = {
            "Suporte Técnico", "Financeiro", "Suporte Técnico", "Financeiro", "Suporte Técnico",
            "Financeiro", "Comercial", "Suporte Técnico", "Comercial", "Suporte Técnico"
        };
        int[] prioridades = { 4, 2, 5, 1, 3, 2, 1, 5, 3, 4 };

        int cadastradas = 0;
        for (int i = 0; i < nomes.length; i++) {
            try {
                central.cadastrarSolicitacao(nomes[i], descricoes[i], categorias[i], prioridades[i], "");
                cadastradas++;
            } catch (Fila.FilaCheiaException | Pilha.PilhaCheiaException e) {
                System.out.println("Não foi possível cadastrar mais solicitações: " + e.getMessage());
                break;
            }
        }

        System.out.println(cadastradas + " solicitação(ões) de teste cadastrada(s) com sucesso!");
    }
}
}
