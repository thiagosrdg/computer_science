public class Node {
    private Pessoa data;
    private Node next;

    public Node(Pessoa data) {
        this.data = data;
        this.next = null;
    }

    public Node(Pessoa data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Pessoa getData() {
        return data;
    }

    public void setData(Pessoa data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
