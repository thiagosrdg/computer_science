public class StaticQueue<E> implements Queue<E> {

    private E[] elements;
    private int head;   // index of the front element
    private int tail;   // index of the next free slot
    private int count;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public StaticQueue(int capacity) {
        this.capacity = capacity;
        this.elements = (E[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    @Override
    public void enqueue(E element) throws OverflowException {
        if (isFull()) {
            throw new OverflowException("Queue is full.");
        }
        elements[tail] = element;
        tail = (tail + 1) % capacity;
        count++;
    }

    @Override
    public E dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("Queue is empty.");
        }
        E element = elements[head];
        elements[head] = null; // help GC
        head = (head + 1) % capacity;
        count--;
        return element;
    }

    @Override
    public E front() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("Queue is empty.");
        }
        return elements[head];
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return count == capacity;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < count; i++) {
            sb.append(elements[(head + i) % capacity]);
            if (i < count - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
