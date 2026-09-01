public class Fila<T> {
    private T[] elementos;
    private int inicio;
    private int fim;
    private int quantidade;


    /*Garante que, seja impossível inicializar
    uma fila com a capacidade menor ou igual a 0
     */

    public Fila(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }

        this.elementos = (T[]) new Object[capacidade];
        this.inicio = 0;
        this.fim = 0;
        this.quantidade = 0;
    }

    /* estaVazia compara a quantidade com 0 para retornar true ou false.
    Será utilizada quando implementarmos a interface.
     */
    public boolean estaVazia(){
        return quantidade == 0;
    }
    /* Semelhante ao estaVazia, porém compara quando a quantidade atinge
    a capacidade do vetor.
     */
    public boolean estaCheia(){
        return quantidade == elementos.length;
    }


    /*Função também importante.
    impede de adicionarmos mais elementos quando a fila já está cheia;
    avança o final da fila, para depois poder atualizar a quantidade.
     */
    public void inserir(T elemento){
        if (estaCheia()) {
            throw new IllegalStateException("A fila está cheia.");
        }
        elementos[fim] = elemento;
        fim = fim + 1;
        if (fim == elementos.length){
            fim = 0;
        }
        quantidade = quantidade + 1;
    }
}