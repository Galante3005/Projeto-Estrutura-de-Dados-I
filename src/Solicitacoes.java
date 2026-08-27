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
    this.codigo = codigo;
    this.solicitante = solicitante;
    this.descricao = descricao;
    this.categoria = categoria;
    this.prioridade = prioridade;
    this.status = "AGUARDANDO";
    this.dataHoraAbertura = LocalDateTime.now();
 }
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
}  }
