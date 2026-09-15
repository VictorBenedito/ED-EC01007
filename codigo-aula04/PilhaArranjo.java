/**
 * EC01007 - Estruturas de Dados - Aula 04
 * Uma implementacao possivel da interface Pilha, so para mostrar que
 * o contrato e a implementacao sao coisas separadas.
 * A implementacao completa e discutida em outubro (Unidade IV).
 */
import java.util.NoSuchElementException;

public class PilhaArranjo<E> implements Pilha<E> {

    private final Object[] dados;
    private int topo;              // proxima posicao livre

    public PilhaArranjo(int capacidade) {
        this.dados = new Object[capacidade];
        this.topo = 0;
    }

    @Override public void push(E e) {
        if (topo == dados.length) throw new IllegalStateException("pilha cheia");
        dados[topo++] = e;
    }

    @SuppressWarnings("unchecked")
    @Override public E pop() {
        if (isEmpty()) throw new NoSuchElementException("pilha vazia");
        E e = (E) dados[--topo];
        dados[topo] = null;
        return e;
    }

    @SuppressWarnings("unchecked")
    @Override public E top() {
        if (isEmpty()) throw new NoSuchElementException("pilha vazia");
        return (E) dados[topo - 1];
    }

    @Override public int size()        { return topo; }
    @Override public boolean isEmpty() { return topo == 0; }

    public static void main(String[] args) {
        // repare: a variavel e do tipo da INTERFACE
        Pilha<String> p = new PilhaArranjo<>(3);
        p.push("EC01007"); p.push("EC01025"); p.push("EC01039");
        System.out.println("size = " + p.size() + ", top = " + p.top());
        System.out.println("pop  = " + p.pop());
        System.out.println("pop  = " + p.pop());
        System.out.println("size = " + p.size() + ", vazia? " + p.isEmpty());
    }
}
