/**
 * EC01007 - Estruturas de Dados - Aula 04
 * O TAD Pilha, projetado em aula.
 *
 * Repare no que NAO esta aqui: nao se diz se por dentro a pilha
 * usa um arranjo ou uma lista encadeada. Esse silencio e o ponto.
 * Em outubro vamos escrever as duas implementacoes desta mesma
 * interface, e o codigo que usa a pilha nao vai mudar uma linha.
 */
public interface Pilha<E> {

    /** Coloca um elemento no topo. */
    void push(E elemento);

    /** Remove e devolve o elemento do topo.
     *  @throws java.util.NoSuchElementException se a pilha estiver vazia */
    E pop();

    /** Devolve o elemento do topo SEM remover.
     *  @throws java.util.NoSuchElementException se a pilha estiver vazia */
    E top();

    /** Quantos elementos a pilha tem agora. */
    int size();

    /** true se nao houver nenhum elemento. */
    boolean isEmpty();
}
