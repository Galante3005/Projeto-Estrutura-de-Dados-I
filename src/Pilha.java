public class Pilha<T> {
    private T[] elementos;
    private int inicio;
    private int fim;
    private int quantidade;

    /*Garante que, seja impossível inicializar
    uma pilha com a capacidade menor ou igual a 0*/
    
    public Pilha(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero.");
        }
        this.elementos = (T[]) new Object[capacidade];
        this.topo = -1;
        this.quantidade = 0;
}

/* estaVazia compara o topo com -1 para retornar true ou false.
    Será utilizada quando implementarmos a interface */

public boolean estaVazia(){
    return topo == -1;
}

/* Semelhante ao estaVazia, porém compara quando o topo
atinge o último índice válido do vetor. */

public boolean estaCheia(){
    return quantidade == elementos.length;
}

/*Função importante.
impede de adicionarmos mais elementos quando a pilha já está cheia.
Avança o topo, para depois inserir o elemento. */

public void empilhar(T elemento){
    if(estaCheia()){
        throw new IllegalArgumentException ("A pilha esta cheia.");
    }
    topo = topo + 1;
    elementos[topo] = elemento;
    quantidade = quantidade + 1;
}

public int getQuantidade(){
    retutn this.quantidade;
}

public T consultarTopo(){
    if(estaVazia()){
        throw new IllegalArgumentException("A pilha esta vazia.");
    }
    else{
        return elementos[topo];
    }
}

/*Função importante.
Remove e retorna o elemento do topo da pilha.
Atualiza o topo e a quantidade de elementos. */

public T desempilhar(){
    if(estaVazia()){
        throw new IllegalArgumentException("A pilha esta vazia.")
    }
    T removido = elementos[topo];
    elementos[topo] = null;
    topo = topo - 1;
    quantidade = quantidade - 1;
    return removido;
}
}