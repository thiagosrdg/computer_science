import java.util.List;

public class MinhaLista<E> {

    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public MinhaLista() {
        head = null;
        size = 0;
    }

    public void insert(int pos, E element) {
        if (pos < 0 || pos > size) throw new IndexOutOfBoundsException();

        Node newNode = new Node(element);

        if (pos == 0) {
            // insere no início: o novo nó aponta para o antigo head
            newNode.next = head;
            head = newNode;
        } else {
            // caminha até o nó anterior à posição desejada
            Node current = head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.next;
            }
            // encadeia o novo nó entre current e o próximo
            newNode.next = current.next;
            current.next = newNode;
        }

        size++;
    }

    // Ex. 4
    public boolean remove(E element) {
        Node previous = null;
        Node current = head;

        while (current != null){
            if (current.data.equals(element)){
                if(previous == null) {
                    head = current.next;        
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    // Ex. 5
    public void insertAfter(E obj1, E obj2) {
        Node current = head;
        
        while (current != null) {
            if (current.data.equals(obj1)) {
                Node newNode = new Node(obj2);
                newNode.next = current.next;
                current.next = newNode;
                size++;
                return;
            }
            current = current.next;
        }
        throw new RuntimeException("Elemento não encontrado");
    }

    // Ex. 6
    public void swap(int pos1, int pos2) {
        // valida se as duas posições existem na lista
        if (pos1 < 0 || pos1 >= size || pos2 < 0 || pos2 >= size) {
            throw new IndexOutOfBoundsException();
        }

        // se as posições são iguais não há nada a trocar
        if (pos1 == pos2) {
            return;
        }

        // garante que firstPos é sempre o menor índice
        // assim o loop precisa caminhar apenas uma vez até o maior
        int firstPos = Math.min(pos1, pos2);
        int secondPos = Math.max(pos1, pos2);
        Node firstNode = null;
        Node secondNode = null;
        Node current = head;

        // caminha até secondPos guardando os dois nós no caminho
        for (int i = 0; i <= secondPos; i++) {
            if (i == firstPos) firstNode = current;
            if (i == secondPos) secondNode = current;
            current = current.next;
        }

        // troca apenas os valores — os ponteiros da lista não mudam
        E temp = firstNode.data;
        firstNode.data = secondNode.data;
        secondNode.data = temp;
    }

    // Ex. 7
    public void flip() {
        // técnica dos três ponteiros: a cada passo, inverte a seta do nó atual
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node next = current.next; // guarda o próximo antes de sobrescrever
            current.next = previous;  // inverte a seta: agora aponta para trás
            previous = current;       // avança previous
            current = next;           // avança current
        }

        // ao final, previous está no último nó — que vira o novo head
        head = previous;
    }

    // Ex. 8
    public void insert(int pos, List<E> list) {
        if (pos < 0 || pos > size) throw new IndexOutOfBoundsException();

        // insere cada elemento da lista na posição correta
        // a cada inserção, avança a posição para manter a ordem original
        for (int i = 0; i < list.size(); i++) {
            insert(pos + i, list.get(i));
        }
    }

    // Ex. 9
    public void dedup() {
        Node current = head;

        while (current != null) {
            Node runner = current; // runner percorre o restante da lista a partir de current

            while (runner.next != null) {
                if (runner.next.data.equals(current.data)) {
                    // achou duplicata: pula o nó duplicado
                    runner.next = runner.next.next;
                    size--;
                } else {
                    runner = runner.next; // só avança se não removeu
                }
            }

            current = current.next;
        }
    }

    // Ex. 10
    @Override
    public boolean equals(Object obj) {
        // verifica se obj é também uma MinhaLista
        if (!(obj instanceof MinhaLista)) return false;

        MinhaLista<?> other = (MinhaLista<?>) obj;

        // listas de tamanhos diferentes não podem ser iguais
        if (this.size != other.size) return false;

        // percorre os dois ao mesmo tempo comparando elemento por elemento
        Node a = this.head;
        MinhaLista<?>.Node b = other.head;

        while (a != null) {
            if (!a.data.equals(b.data)) return false;
            a = a.next;
            b = b.next;
        }

        return true;
    }

    // Ex. 11
    public MinhaLista<E> clone() {
        MinhaLista<E> copy = new MinhaLista<>();
        Node current = head;
        int pos = 0;

        // percorre a lista original inserindo cada elemento na cópia
        // os elementos em si não são duplicados — apenas a estrutura da lista
        while (current != null) {
            copy.insert(pos, current.data);
            pos++;
            current = current.next;
        }

        return copy;
    }

    // Ex. 12
    public int remove(int start, int end) {
        if (start < 0 || end >= size || start > end) throw new IndexOutOfBoundsException();

        int count = end - start + 1; // quantidade de elementos a remover

        // remove o nó na posição start exatamente 'count' vezes
        // como a lista encolhe, a posição start sempre aponta pro próximo a remover
        for (int i = 0; i < count; i++) {
            removeAt(start);
        }

        return count;
    }

    // método auxiliar para remove(int start, int end): remove o nó em uma posição específica
    private void removeAt(int pos) {
        if (pos == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    // Ex. 13
    public MinhaLista<E> split(int pos) {
        if (pos < 0 || pos >= size) throw new IndexOutOfBoundsException();

        MinhaLista<E> newList = new MinhaLista<>();

        if (pos == 0) {
            // tudo vai para a nova lista, a atual fica vazia
            newList.head = this.head;
            newList.size = this.size;
            this.head = null;
            this.size = 0;
            return newList;
        }

        // caminha até o nó anterior à posição de corte
        Node current = head;
        for (int i = 0; i < pos - 1; i++) {
            current = current.next;
        }

        // current.next é o primeiro nó da nova lista
        newList.head = current.next;
        newList.size = this.size - pos;

        // corta a ligação: a lista atual termina em current
        current.next = null;
        this.size = pos;

        return newList;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
