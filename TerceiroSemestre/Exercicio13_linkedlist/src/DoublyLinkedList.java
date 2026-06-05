// Lista duplamente encadeada genérica (exercícios 5 a 8)
public class DoublyLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> next, prev;
        Node(T data) { this.data = data; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Adiciona elemento no final da lista
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T get(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    public int size() { return size; }

    // Exercício 5: troca os valores nas posições pos1 e pos2
    public void swap(int pos1, int pos2) {
        Node<T> n1 = nodeAt(pos1);
        Node<T> n2 = nodeAt(pos2);
        T tmp = n1.data;
        n1.data = n2.data;
        n2.data = tmp;
    }

    private Node<T> nodeAt(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current;
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
