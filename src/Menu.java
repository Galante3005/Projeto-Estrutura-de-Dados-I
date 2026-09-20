import java.util.Scanner;

public class Menu {
    private Scanner leitor;
    private CentralAtendimento central;

    public Menu(CentralAtendimento central) {
        this.central = central;
        this.leitor = new Scanner(System.in);
    }

    private void exibirMenu() {
        System.out.println("\n========================================");
        System.out.println("       CENTRAL DE ATENDIMENTO");
        System.out.println("========================================");
        System.out.println("1 - Cadastrar nova solicitação");
        System.out.println("2 - Consultar próxima solicitação");
        System.out.println("3 - Atender próxima solicitação");
        System.out.println("4 - Exibir fila de solicitações");
        System.out.println("5 - Exibir quantidade de solicitações");
        System.out.println("6 - Consultar última operação");
        System.out.println("7 - Exibir histórico de operações");
        System.out.println("8 - Desfazer última operação");
        System.out.println("9 - Gerar solicitações automáticas");
        System.out.println("0 - Encerrar");
        System.out.println("========================================");
    }

    public void executar() {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarSolicitacao();
                    break;
                case 2:
                    consultarProximaSolicitacao();
                    break;
                case 3:
                    atenderProximaSolicitacao();
                    break;
                case 4:
                    exibirFilaSolicitacoes();
                    break;
                case 5:
                    exibirQuantidadeSolicitacoes();
                    break;
                case 6:
                    consultarUltimaOperacao();
                    break;
                case 7:
                    exibirHistoricoOperacoes();
                    break;
                case 8:
                    desfazerUltimaOperacao();
                    break;
                case 9:
                    gerarSolicitacoesAutomaticas();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void cadastrarSolicitacao() {
        String solicitante = lerTextoObrigatorio("Digite o nome do solicitante: ");
        String descricao = lerTextoObrigatorio("Descreva o problema: ");
        String categoria = lerTextoObrigatorio("Digite a categoria: ");

        int prioridade;
        do {
            prioridade = lerInteiro("Qual o grau de prioridade (de 1 a 5): ");

            if (prioridade < 1 || prioridade > 5) {
                System.out.println("A prioridade deve estar entre 1 e 5.");
            }
        } while (prioridade < 1 || prioridade > 5);

        Solicitacoes novaSolicitacao = central.cadastrarSolicitacao(
                solicitante,
                descricao,
                categoria,
                prioridade
        );

        System.out.println("Solicitação cadastrada com sucesso:");
        System.out.println(novaSolicitacao);
    }

    private void consultarProximaSolicitacao() {
        if (central.filaEstaVazia()) {
            System.out.println("Não existem solicitações aguardando atendimento.");
            return;
        }

        System.out.println("Próxima solicitação:");
        System.out.println(central.consultarProximaSolicitacao());
    }

    private void atenderProximaSolicitacao() {
        if (central.filaEstaVazia()) {
            System.out.println("Não existem solicitações aguardando atendimento.");
            return;
        }

        String responsavel = lerTextoObrigatorio("Digite o nome do responsável: ");
        Solicitacoes solicitacao = central.iniciarProximoAtendimento(responsavel);

        System.out.println("Atendimento iniciado com sucesso:");
        System.out.println(solicitacao);
    }

    private void exibirFilaSolicitacoes() {
        if (central.filaEstaVazia()) {
            System.out.println("A fila de solicitações está vazia.");
            return;
        }

        System.out.println(central.consultarFilaAguardando());
    }

    private void exibirQuantidadeSolicitacoes() {
        System.out.println(
                "Quantidade de solicitações aguardando: "
                        + central.getQuantidadeAguardando()
        );
    }

    private void consultarUltimaOperacao() {
        if (central.historicoEstaVazio()) {
            System.out.println("O histórico de operações está vazio.");
            return;
        }

        System.out.println("Última operação realizada:");
        System.out.println(central.consultarUltimaOperacao());
    }

    private void exibirHistoricoOperacoes() {
        if (central.historicoEstaVazio()) {
            System.out.println("O histórico de operações está vazio.");
            return;
        }

        System.out.println(central.exibirHistoricoOperacoes());
    }

    private void desfazerUltimaOperacao() {
        if (central.historicoEstaVazio()) {
            System.out.println("Não existe operação para remover.");
            return;
        }

        Operacao operacaoRemovida = central.removerUltimaOperacao();
        System.out.println("Operação removida do histórico:");
        System.out.println(operacaoRemovida);
        System.out.println("Os efeitos da operação não foram revertidos.");
    }

    private void gerarSolicitacoesAutomaticas() {
        // TODO: conectar aqui a funcionalidade desenvolvida pelo outro integrante.
    }

    private String lerTextoObrigatorio(String mensagem) {
        String texto;

        do {
            System.out.print(mensagem);
            texto = leitor.nextLine().trim();

            if (texto.isBlank()) {
                System.out.println("Esse campo deve ser preenchido.");
            }
        } while (texto.isBlank());

        return texto;
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);

            if (leitor.hasNextInt()) {
                int numero = leitor.nextInt();
                leitor.nextLine();
                return numero;
            }

            System.out.println("Digite um número inteiro válido.");
            leitor.nextLine();
        }
    }
}
