import java.time.LocalDateTime;

public class Solicitacoes {
    private int codigo;
    private String solicitante;
    private String descricao;
    private String categoria;
    private int prioridade;
    private String status;
    private String responsavel;
    private LocalDateTime dataHoraAbertura;

    public Solicitacoes(int codigo, String solicitante, String descricao, String categoria, int prioridade) {
        /* os if's abaixo servem para fazer a verificação de cada variável dentro de
        uma solicitação.
         */

        if (solicitante == null || solicitante.isBlank()) {
            throw new IllegalArgumentException("O nome do solicitante deve ser preenchido.");
        }
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("A categoria deve ser preenchida.");
        }
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descricao deve ser preenchida.");
        }
        if (prioridade > 5 || prioridade < 1) {
            throw new IllegalArgumentException("A prioridade deve ser de 1 a 5");

        }
        this.codigo = codigo;
        this.solicitante = solicitante;
        this.descricao = descricao;
        this.categoria = categoria;
        this.prioridade = prioridade;
        this.status = "AGUARDANDO";
        this.dataHoraAbertura = LocalDateTime.now();
    }

    /* get's necessários para conseguirmos pegar cada varíavel escrita pelo proprio
    usuário do sistema
         */
    public int getCodigo() {
        return this.codigo;
    }

    public String getSolicitante() {
        return this.solicitante;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public int getPrioridade() {
        return this.prioridade;
    }

    public String getStatus() {
        return this.status;
    }

    public String getResponsavel() {
        return this.responsavel;
    }

    public LocalDateTime getDataHoraAbertura() {
        return this.dataHoraAbertura;
    }

    /* Função Abaixo EXTREMAMENTE IMPORTANTE!
    a função basicamente impede o usuário de finalizar uma solicitação que nao esteja em andamento.
    se o status é diferente de em andamento, e caso seja ele nega a possibilidade
    de finalizar a solicitação.
    */
    public void finalizarAtendimento(){
        if (!"EM_ATENDIMENTO".equals(this.status)){
            throw new IllegalStateException("Somente solicitações em atendimento podem ser finalizadas.");
        }
        this.status = "FINALIZADO";
    }


    /* Função Abaixo EXTREMAMENTE IMPORTANTE!
     a função basicamente impede o usuário de aceitar resolver uma solicitação
     se informar quem está sendo o responsável.
     o segundo if funciona como um verificador de status, onde ele pergunta
     se o status é diferente de aguardando, e caso seja ele nega a possibilidade
     de resolver a solicitação.
     */
    public void iniciarAtendimento(String responsavel) {
        if (responsavel == null || responsavel.isBlank()){
            throw new IllegalArgumentException("O responsável deve ser preenchido.");}
            if (!"AGUARDANDO".equals(this.status)) {
                throw new IllegalStateException("Somente solicitações em aguardo podem iniciar atendimento.");
            }
            this.responsavel = responsavel;
            this.status = "EM_ATENDIMENTO";
        }


}