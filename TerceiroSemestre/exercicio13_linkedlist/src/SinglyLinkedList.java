// Lista simplesmente encadeada genérica (exercícios 1 a 4)
public class SinglyLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> head;
    private int size;

    // Adiciona elemento no final da lista
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    public int size() { return size; }

    // Exercício 3: divide a lista na primeira ocorrência de divisor.
    // Esta lista fica com os elementos APÓS o divisor.
    // Retorna nova lista com os elementos do início até o divisor (inclusive).
    public SinglyLinkedList<T> split(T divisor) {
        SinglyLinkedList<T> prefix = new SinglyLinkedList<>();
        Node<T> current = head;

        while (current != null) {
            prefix.add(current.data);
            if (current.data.equals(divisor)) {
                head = current.next;   // esta lista começa após o divisor
                size -= prefix.size;
                current.next = null;   // desconecta o divisor do restante
                return prefix;
            }
            current = current.next;
        }
        return new SinglyLinkedList<>(); // divisor não encontrado
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        return sb.append("]").toString();
    }
}
