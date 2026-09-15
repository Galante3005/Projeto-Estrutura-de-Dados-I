import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        CentralAtendimento central = new CentralAtendimento();

        String[] nomes = {
            "Valter Augusto", "Gustavo Domingues", "Thiago Nogueira", "Camila Duarte", "Lucas Pereira",
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
            central.cadastrarSolicitacao(nomes[i], descricoes[i], categorias[i], prioridades[i]);
            cadastradas++;
        }

        System.out.println(cadastradas + " solicitação(ões) de teste cadastrada(s) com sucesso!");
        System.out.println(central.consultarFilaAguardando());
    }
}
