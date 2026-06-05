// Pilha estática genérica com capacidade fixa (array)
public class StaticStack<T> {

    private Object[] data;
    private int top;

    public StaticStack(int capacity) {
        data = new Object[capacity];
        top = -1;
    }

    public void push(T item) {
        if (isFull()) throw new RuntimeException("Pilha cheia");
        data[++top] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia");
        return (T) data[top--];
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new RuntimeException("Pilha vazia");
        return (T) data[top];
    }

    public boolean isEmpty() { return top == -1; }
    public boolean isFull()  { return top == data.length - 1; }
    public int size()        { return top + 1; }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("topo→[");
        for (int i = top; i >= 0; i--) {
            sb.append(data[i]);
            if (i > 0) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}
