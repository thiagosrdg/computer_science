public interface Queue<E> {

    void enqueue(E element) throws OverflowException;

    E dequeue() throws UnderflowException;

    E front() throws UnderflowException;

    boolean isEmpty();

    boolean isFull();

    int size();
}
