public class Fila<T> {
    private T[] elementos;
    private int inicio;
    private int fim;
    private int quantidade;
    private static final int CAPACIDADE_PADRAO = 100;
    public Fila(){
        this(CAPACIDADE_PADRAO);
    }


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

    public int getQuantidade() {
        return this.quantidade;
    }
    public T consultarProximo(){
        if (estaVazia()){
            throw new IllegalStateException("A fila está vazia.");
        }
        else {
            return elementos[inicio];
        }
    }

    /*Função também importante.
   Remove e retorna o primeiro elemento da fila;
   Atualiza o início e a quantidade de elementos.
    */
    public T removerProximo(){
        if (estaVazia()){
         throw new IllegalStateException("A fila está vazia.");
        }
        T removido = elementos[inicio];
        elementos[inicio]  = null;
        inicio = inicio + 1;
        if (inicio == elementos.length){
            inicio = 0;
        }
        quantidade = quantidade - 1;
        return removido;
    }


    /*
    Verifica se a fila está vazia antes de consultar o último elemento.
    Como fim aponta para a próxima posição livre, o último elemento
    normalmente está na posição fim - 1.
    Se fim for igual a zero, significa que o índice deu a volta no
    vetor circular. Nesse caso, o último elemento está na posição
     elementos.length - 1.
    */
    public T consultarUltimo(){
        if (estaVazia()){
            throw new IllegalStateException("A fila está vazia!");
        }
        int ultimo;
        if (fim != 0){
            ultimo = fim -1;
        }
        else {
            ultimo = elementos.length -1;
        }
        return elementos[ultimo];
    }

}